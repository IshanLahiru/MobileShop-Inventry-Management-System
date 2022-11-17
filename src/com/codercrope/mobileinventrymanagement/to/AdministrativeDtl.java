package com.codercrope.mobileinventrymanagement.to;

public class AdministrativeDtl {
    private String administrativeDtlId;
    private String administrativeStats;

    public AdministrativeDtl(String administrativeDtlId, String administrativeStats) {
        this.administrativeDtlId = administrativeDtlId;
        this.administrativeStats = administrativeStats;
    }

    public AdministrativeDtl(AdministrativeDtl user) {
        this.administrativeDtlId = user.administrativeDtlId;
        this.administrativeStats = user.administrativeStats;
    }

    public String getAdministrativeDtlId() {
        return administrativeDtlId;
    }

    public void setAdministrativeDtlId(String administrativeDtlId) {
        this.administrativeDtlId = administrativeDtlId;
    }

    public String getAdministrativeStats() {
        return administrativeStats;
    }

    public void setAdministrativeStats(String administrativeStats) {
        this.administrativeStats = administrativeStats;
    }
}
