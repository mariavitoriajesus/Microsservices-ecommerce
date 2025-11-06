package com.storefront.dto;

public class InventoryResponse {
    private String pruductId;
    private Integer availableQuantity;

    public String getPruductId() {
        return pruductId;
    }

    public void setPruductId(String pruductId) {
        this.pruductId = pruductId;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
