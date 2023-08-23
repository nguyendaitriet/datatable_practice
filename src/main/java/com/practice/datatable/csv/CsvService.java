package com.practice.datatable.csv;

import com.practice.datatable.model.*;
import com.practice.datatable.model.repository.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvService {
    private static final String validExtension = "csv";

    @Autowired
    private DesignBrandRepo designBrandRepo;
    @Autowired
    private CurrencyRepo currencyRepo;
    @Autowired
    private DesignStatusRepo designStatusRepo;
    @Autowired
    private MarketRepo marketRepo;
    @Autowired
    private TemplateStandardRepo templateStandardRepo;
    @Autowired
    private TemplateCategoryRepo templateCategoryRepo;

    public void handleFiles(MultipartFile[] multipartFiles) {
        Arrays.stream(multipartFiles).forEach(file -> {
            ArrayList<String> validFileNames = Arrays.stream(FileName.class.getEnumConstants()).map(FileName::getValue).collect(Collectors.toCollection(ArrayList::new));
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            if (!validExtension.equals(fileExtension)) return;
            String fileName = FilenameUtils.getBaseName(file.getOriginalFilename());
            if (!validFileNames.contains(fileName)) return;
            convertContentToObjects(file, fileName);
        });
    }

    public void convertContentToObjects(MultipartFile multipartFile, String fileName) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), StandardCharsets.UTF_8))) {
            long commaCount = reader.readLine().chars().filter(character -> character == ',').count();
            List<String> content = reader.lines().skip(1).collect(Collectors.toList());
            if (commaCount == 1) {
                processTwoColumnsFile(content, fileName);
            }
            if (fileName.equals(FileName.CURRENCY.getValue())) {
                processCurrencyFile(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processTwoColumnsFile(List<String> content, String fileName) {
        List<SimpleModel> simpleModels = convertToSimpleModelList(content);
        convertToModelListAndSave(simpleModels, fileName);
    }

    public void processCurrencyFile(List<String> content) {
        List<Currency> currencies = content.stream().map(item -> {
            String[] values = item.split(",");
            return new Currency(values[1], values[2]);
        }).collect(Collectors.toList());
        currencyRepo.saveAll(currencies);
    }

    public List<SimpleModel> convertToSimpleModelList(List<String> content) {
        return content.stream().map(item -> new SimpleModel(item.split(",")[1])).collect(Collectors.toList());
    }

    public void convertToModelListAndSave(List<SimpleModel> simpleModels, String fileName) {
        if (fileName.equals(FileName.DESIGN_BRAND.getValue())) {
            List<DesignBrand> designBrands = simpleModels.stream().map(item -> new DesignBrand(item.getName())).collect(Collectors.toList());
            designBrandRepo.saveAll(designBrands);
        }
        if (fileName.equals(FileName.TEMPLATE_STANDARD.getValue())) {
            List<TemplateStandard> templateStandards = simpleModels.stream().map(item -> new TemplateStandard(item.getName())).collect(Collectors.toList());
            templateStandardRepo.saveAll(templateStandards);
        }
        if (fileName.equals(FileName.DESIGN_STATUS.getValue())) {
            List<DesignStatus> designStatus = simpleModels.stream().map(item -> new DesignStatus(item.getName())).collect(Collectors.toList());
            designStatusRepo.saveAll(designStatus);
        }
        if (fileName.equals(FileName.MARKET.getValue())) {
            List<Market> markets = simpleModels.stream().map(item -> new Market(item.getName())).collect(Collectors.toList());
            marketRepo.saveAll(markets);
        }
        if (fileName.equals(FileName.TEMPLATE_CATEGORY.getValue())) {
            List<TemplateCategory> templateCategories = simpleModels.stream().map(item -> new TemplateCategory(item.getName())).collect(Collectors.toList());
            templateCategoryRepo.saveAll(templateCategories);
        }
    }
}
