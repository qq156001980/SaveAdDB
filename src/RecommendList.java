/**
 * Created by Hunter on 14/11/2.
 */
public class RecommendList {


    private String mac;

    private String ad_top1;

    private String ad_top2;

    private String ad_top3;

    private String ad_top4;

    private String ad_top5;

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getAd_top1() {
        return ad_top1;
    }

    public void setAd_top1(String ad_top1) {
        this.ad_top1 = ad_top1;
    }

    public String getAd_top2() {
        return ad_top2;
    }

    public void setAd_top2(String ad_top2) {
        this.ad_top2 = ad_top2;
    }

    public String getAd_top3() {
        return ad_top3;
    }

    public void setAd_top3(String ad_top3) {
        this.ad_top3 = ad_top3;
    }

    public String getAd_top4() {
        return ad_top4;
    }

    public void setAd_top4(String ad_top4) {
        this.ad_top4 = ad_top4;
    }

    public String getAd_top5() {
        return ad_top5;
    }

    public void setAd_top5(String ad_top5) {
        this.ad_top5 = ad_top5;
    }

    @Override
    public String toString() {
        return "'"+mac+"','"+ad_top1+"','"+ad_top2+"','"+ad_top3+"','"+ad_top4+"','"+ad_top5+"'";
    }
}
