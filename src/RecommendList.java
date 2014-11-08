/**
 * Created by Hunter on 14/11/2.
 */
public class RecommendList {


    private String mac;

    private String phone="0";

    private String province="0";

    private String city="0";

    private String area="0";

    private String age="0";

    private String salary="0";

    private String sex="0";




    private String ad_top1="0";

    private String ad_top2="0";

    private String ad_top3="0";

    private String ad_top4="0";

    private String ad_top5="0";

    private String ad_feed1="0";

    private String ad_feed2="0";

    private String ad_feed3="0";

    private String ad_feed4="0";

    private String ad_feed5="0";

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
        return "'"+mac+"','"+phone+"','"+province+"','"+city+"','"+area+"','"+age+"','"+salary+"','"+sex+"','"+ad_top1+"','"+ad_top2+"','"+ad_top3+"','"+ad_top4+"','"+ad_top5+"','"+
                ad_feed1+"','"+ad_feed2+"','"+ad_feed3+"','"+ad_feed4+"','"+ad_feed5+"'";
    }
}
