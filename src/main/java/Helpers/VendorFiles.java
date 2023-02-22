package Helpers;

public enum VendorFiles {
    vendorComplaint(new String[]{"VENDOR COMPLAINT DETAILS", "THIS FILE STORES VENDOR COMPLAINT DETAILS",
            "VENDOR ID", "DATE OF COMPLAINT", "DESCRIPTION", "COMPLAINT NUMBER", "STATUS"}),
    vendorDetail(new String[]{"VENDOR PROFILE DETAILS", "THIS FILE STORES THE PROFILE DETAILS OF VENDORS",
            "VENDOR ID", "VENDOR NAME", "CONTACT NUMBER", "EMAIL", "BUILDING", "UNIT NAME", "MOVE-IN DATE", "PROFILE PICTURE", "BUSINESS REG NUMBER", "NATIONALITY", "USERNAME", "PASSWORD"}),
    vendorPay(new String[]{"VENDOR PAYMENT DETAILS", "THIS FILE STORES DETAILS OF VENDOR WHO MAKE PAYMENTS FOR RENTAL, UTILITIES OR SERVICES",
            "VENDOR ID", "PAYMENT DATE", "AMOUNT", "RECEIPT ID"});
    private final String[] headers;

    private VendorFiles(String[] headers) {
        this.headers = headers;
    }

    public String[] getHeaders() {
        return headers;
    }
}


