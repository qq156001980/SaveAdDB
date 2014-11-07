import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hunter on 14/11/3.
 */
public class Function {
    private static final String EXIST="exist";

    private static final String NO_EXIST="no_exist";

    private static final String ERR="err";

    private  static Connection conn;

    private  static Statement st;

    private List<RecommendList> insertOrUpdatetList=new ArrayList<RecommendList>();


    //读入需要的列表
    public  void inputFile(String path){

        File file=new File(path);

        BufferedReader br;


        try{

            br=new BufferedReader(new FileReader(file));

            String tempString=null;

            while((tempString=br.readLine())!=null){
                String mac="";

                String[] separate=tempString.split("\t");

                mac=separate[0].trim();

                ArrayList<String> list=sort(separate[1].trim());


                String ad_top1=list.get(0);

                String ad_top2=list.get(1);

                String ad_top3=list.get(2);

                String ad_top4=list.get(3);

                String ad_top5=list.get(4);

                RecommendList rl=new RecommendList();

                rl.setMac(mac);

                rl.setAd_top1(ad_top1);

                rl.setAd_top2(ad_top2);

                rl.setAd_top3(ad_top3);

                rl.setAd_top4(ad_top4);

                rl.setAd_top5(ad_top5);

                insertOrUpdatetList.add(rl);

            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public static ArrayList<String> sort(String s){

        int flag=0;

        double[] weight=new double[5];

        String[] ad_id=new String[5];

        ArrayList<String> list=new ArrayList<String>();

        String[] separate=s.split(" ");

        for(int i=0;i<separate.length;i++){

            String[] tempSeparate=separate[i].split(":");

            String tempS=tempSeparate[0];

            double tempD=Double.parseDouble(tempSeparate[1].trim());

            if(flag==0){
                ad_id[i]=tempS;

                weight[i]=tempD;


                flag=1;

                continue;
            }

            for(int j=i-1;j>=0;j--){

                if(weight[j]<=tempD){

                    for(int k=i;k>j;k--){

                        weight[k]=weight[k-1];
                        ad_id[k]=ad_id[k-1];

                    }
                    weight[j]=tempD;
                    ad_id[j]=tempS;
                    break;
                }

                weight[i]=tempD;
                ad_id[i]=tempS;

            }

        }

        for(int l=0;l<5;l++){

            list.add(ad_id[l]);
        }

        return list;

    }




    //插入数据记录
    public  void insert(RecommendList rl) {


        try {
            String sql = "INSERT INTO " +DBConn.getTableName()+ "(mac,ad_top1,ad_top2,ad_top3,ad_top4,ad_top5)VALUE(" + rl.toString() + ");"; // 插入数据的sql语句

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数

            System.out.println("insert into " + count + " lines"); //输出插入操作的处理结果


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("fail" + e.getMessage());
        }
    }



    public  void update(RecommendList rl) {
        try {
            String sql = "update " + DBConn.getTableName() + " set ad_top1='" + rl.getAd_top1()
                    + "',ad_top2='" + rl.getAd_top2() + "',ad_top3='" + rl.getAd_top3()
                    + "',ad_top4='" + rl.getAd_top4() + "',ad_top5='" + rl.getAd_top5()
                    + "'where mac ='" + rl.getMac() + "';";// 更新数据的sql语句


            st = conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量

            int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

            System.out.println("update " + count + " lines");      //输出更新操作的处理结果


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update failure");
        }


    }


    public  String queryById(String id) {

        try {
            String sql = "select *from " + DBConn.getTableName()+" where mac='"+id+"';";     // 查询数据的sql语句


            System.out.println(sql);

            ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
            boolean b=rs.next();



            if(b){
                rs.close();
                return EXIST;
            }else {
                rs.close();
                return NO_EXIST;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("query failure");
            return ERR;
        }



    }

    //操作函数
    public  void operate(){
        for(int i=0;i<insertOrUpdatetList.size();i++){
            RecommendList rl=insertOrUpdatetList.get(i);
            String response=queryById(rl.getMac());
            if(EXIST.equals(response)){
                update(rl);
            }else if(NO_EXIST.equals(response)){
                insert(rl);
            }else {
                System.out.println(rl.toString());
            }
        }
    }


    public static void main(String[] Args){

        Function f=new Function();
        if(Args.length!=1){
            System.err.println("Please input the file path");
            System.exit(1);
        }

        try{


            conn=DBConn.getConnection();
            st=conn.createStatement();

            f.inputFile(Args[0]);
            f.operate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(st!=null){
                try{

                    st.close();

                }catch(SQLException e){
                    e.printStackTrace();
                }
            }

            if(conn!=null){
                try{

                    conn.close();
                    System.out.print("done");

                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }



    }


}
