/**
 * 
 */
package com.holidu.interview.assignment.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author prachi
 *
 */
public class StreetTreeCensusData implements Serializable {

    @JsonProperty("address")
    private String address;
    @JsonProperty("bbl")
    private String bbl;
    @JsonProperty("bin")
    private String bin;
    @JsonProperty("block_id")
    private String blockd;
    @JsonProperty("boro_ct")
    private String boroCt;
    @JsonProperty("borocode")
    private String borocode;
    @JsonProperty("boroname")
    private String boroname;
    @JsonProperty("brch_light")
    private String brchLight;
    @JsonProperty("brch_other")
    private String brchOther;
    @JsonProperty("brch_shoe")
    private String brchShoe;
    @JsonProperty("cb_num")
    private String cbNum;
    @JsonProperty("census_tract")
    private String censusTract;
    @JsonProperty("cncldist")
    private String cncldist;
    @JsonProperty("council_district")
    private String councilDistrict;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("curb_loc")
    private String curbLoc;
    @JsonProperty("guards")
    private String guards;
    @JsonProperty("health")
    private String health;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("nta")
    private String nta;
    @JsonProperty("nta_name")
    private String ntaName;
    @JsonProperty("problems")
    private String problems;
    @JsonProperty("root_grate")
    private String rootGrate;
    @JsonProperty("root_other")
    private String rootOther;
    @JsonProperty("root_stone")
    private String rootStone;
    @JsonProperty("sidewalk")
    private String sidewalk;
    @JsonProperty("spc_common")
    private String spcCommon;
    @JsonProperty("spc_latin")
    private String spcLatin;
    @JsonProperty("st_assem")
    private String stAssem;
    @JsonProperty("st_senate")
    private String stSenate;
    @JsonProperty("state")
    private String state;
    @JsonProperty("status")
    private String status;
    @JsonProperty("steward")
    private String steward;
    @JsonProperty("stump_diam")
    private String stumpDiam;
    @JsonProperty("tree_dbh")
    private String treeDbh;
    @JsonProperty("tree_id")
    private String treeId;
    @JsonProperty("trnk_light")
    private String trnkLight;
    @JsonProperty("trnk_other")
    private String trnkOther;
    @JsonProperty("trunk_wire")
    private String trunkWire;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("x_sp")
    private Double xsp;
    @JsonProperty("y_sp")
    private Double ysp;
    @JsonProperty("zip_city")
    private String zipCity;
    @JsonProperty("zipcode")
    private String zipcode;

    public StreetTreeCensusData() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBbl() {
        return bbl;
    }

    public void setBbl(String bbl) {
        this.bbl = bbl;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getBlockd() {
        return blockd;
    }

    public void setBlockd(String blockd) {
        this.blockd = blockd;
    }

    public String getBoroCt() {
        return boroCt;
    }

    public void setBoroCt(String boroCt) {
        this.boroCt = boroCt;
    }

    public String getBorocode() {
        return borocode;
    }

    public void setBorocode(String borocode) {
        this.borocode = borocode;
    }

    public String getBoroname() {
        return boroname;
    }

    public void setBoroname(String boroname) {
        this.boroname = boroname;
    }

    public String getBrchLight() {
        return brchLight;
    }

    public void setBrchLight(String brchLight) {
        this.brchLight = brchLight;
    }

    public String getBrchOther() {
        return brchOther;
    }

    public void setBrchOther(String brchOther) {
        this.brchOther = brchOther;
    }

    public String getBrchShoe() {
        return brchShoe;
    }

    public void setBrchShoe(String brchShoe) {
        this.brchShoe = brchShoe;
    }

    public String getCbNum() {
        return cbNum;
    }

    public void setCbNum(String cbNum) {
        this.cbNum = cbNum;
    }

    public String getCensusTract() {
        return censusTract;
    }

    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public String getCncldist() {
        return cncldist;
    }

    public void setCncldist(String cncldist) {
        this.cncldist = cncldist;
    }

    public String getCouncilDistrict() {
        return councilDistrict;
    }

    public void setCouncilDistrict(String councilDistrict) {
        this.councilDistrict = councilDistrict;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCurbLoc() {
        return curbLoc;
    }

    public void setCurbLoc(String curbLoc) {
        this.curbLoc = curbLoc;
    }

    public String getGuards() {
        return guards;
    }

    public void setGuards(String guards) {
        this.guards = guards;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public String getNtaName() {
        return ntaName;
    }

    public void setNtaName(String ntaName) {
        this.ntaName = ntaName;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public String getRootGrate() {
        return rootGrate;
    }

    public void setRootGrate(String rootGrate) {
        this.rootGrate = rootGrate;
    }

    public String getRootOther() {
        return rootOther;
    }

    public void setRootOther(String rootOther) {
        this.rootOther = rootOther;
    }

    public String getRootStone() {
        return rootStone;
    }

    public void setRootStone(String rootStone) {
        this.rootStone = rootStone;
    }

    public String getSidewalk() {
        return sidewalk;
    }

    public void setSidewalk(String sidewalk) {
        this.sidewalk = sidewalk;
    }

    public String getSpcCommon() {
        return spcCommon;
    }

    public void setSpcCommon(String spcCommon) {
        this.spcCommon = spcCommon;
    }

    public String getSpcLatin() {
        return spcLatin;
    }

    public void setSpcLatin(String spcLatin) {
        this.spcLatin = spcLatin;
    }

    public String getStAssem() {
        return stAssem;
    }

    public void setStAssem(String stAssem) {
        this.stAssem = stAssem;
    }

    public String getStSenate() {
        return stSenate;
    }

    public void setStSenate(String stSenate) {
        this.stSenate = stSenate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSteward() {
        return steward;
    }

    public void setSteward(String steward) {
        this.steward = steward;
    }

    public String getStumpDiam() {
        return stumpDiam;
    }

    public void setStumpDiam(String stumpDiam) {
        this.stumpDiam = stumpDiam;
    }

    public String getTreeDbh() {
        return treeDbh;
    }

    public void setTreeDbh(String treeDbh) {
        this.treeDbh = treeDbh;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getTrnkLight() {
        return trnkLight;
    }

    public void setTrnkLight(String trnkLight) {
        this.trnkLight = trnkLight;
    }

    public String getTrnkOther() {
        return trnkOther;
    }

    public void setTrnkOther(String trnkOther) {
        this.trnkOther = trnkOther;
    }

    public String getTrunkWire() {
        return trunkWire;
    }

    public void setTrunkWire(String trunkWire) {
        this.trunkWire = trunkWire;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Double getXsp() {
        return xsp;
    }

    public void setXsp(Double xsp) {
        this.xsp = xsp;
    }

    public Double getYsp() {
        return ysp;
    }

    public void setYsp(Double ysp) {
        this.ysp = ysp;
    }

    public String getZipCity() {
        return zipCity;
    }

    public void setZipCity(String zipCity) {
        this.zipCity = zipCity;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
