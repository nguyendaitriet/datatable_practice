package com.practice.datatable.csv;

public enum FileName {
    DESIGN_BRAND("design_brand"),
    DESIGN_STATUS("design_status"),
    TEMPLATE_STANDARD("template_standard"),
    MARKET("market"),
    TEMPLATE_CATEGORY("template_category"),
    CURRENCY("currency");

    private final String value;

    FileName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FileName parseFileName(String value) {
        FileName[] values = values();
        for (FileName status : values) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("invalid parse " + value);
    }
}
