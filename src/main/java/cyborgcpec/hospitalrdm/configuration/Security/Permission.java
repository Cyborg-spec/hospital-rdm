package cyborgcpec.hospitalrdm.configuration.Security;

public enum Permission {

    API_READ("api:read"),
    API_WRITE("api:write");

    private final String permission;

    Permission(String permission){
        this.permission=permission;
    }

    public String getPermission() {
        return permission;
    }
}
