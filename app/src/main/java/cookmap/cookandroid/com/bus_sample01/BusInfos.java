package cookmap.cookandroid.com.bus_sample01;

/**
 * Created by 8 on 2017-08-18.
 */

public class BusInfos {

    private String buslinenum; //버스 번호
    private String bustype; //일반, 마을, 급행
    private String companyid; //회사
    private String lineId; //노선아이디
    private String startpoint; //출발점
    private String endpoint; //종착점
    private String firsttime; //첫차 시간
    private String endtime; //막차 시간
    private String headway; //배차간격
    private String headwayHoli; //배차간격(휴일)
    private String headwayNorm; //배차간격(일반)
    private String headwayPeak; //배차간격(출퇴근)

    public BusInfos(){
        buslinenum = null;
        bustype = null;
        companyid = null;
        lineId = null;
        startpoint = null;
        endpoint = null;
        firsttime = null;
        endtime = null;
        headway = null;
        headwayHoli = null;
        headwayNorm = null;
        headwayPeak = null;
    }



    public String getBuslinenum() {
        return buslinenum;
    }

    public void setBuslinenum(String buslinenum) {
        this.buslinenum = buslinenum;
    }

    public String getBustype() {
        return bustype;
    }

    public void setBustype(String bustype) {
        this.bustype = bustype;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getHeadway() {
        return headway;
    }

    public void setHeadway(String headway) {
        this.headway = headway;
    }

    public String getHeadwayHoli() {
        return headwayHoli;
    }

    public void setHeadwayHoli(String headwayHoli) {
        this.headwayHoli = headwayHoli;
    }

    public String getHeadwayNorm() {
        return headwayNorm;
    }

    public void setHeadwayNorm(String headwayNorm) {
        this.headwayNorm = headwayNorm;
    }

    public String getHeadwayPeak() {
        return headwayPeak;
    }

    public void setHeadwayPeak(String headwayPeak) {
        this.headwayPeak = headwayPeak;
    }
}


