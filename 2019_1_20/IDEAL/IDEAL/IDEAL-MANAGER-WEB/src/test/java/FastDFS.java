import cn.ideal.common.utils.FastDFSClient;
import org.junit.Test;

public class FastDFS {

//    @Test
//    public void uploadFile() throws IOException, MyException {
//        //1、向工程中添加jar包
//        //2、创建一个配置文件。配置tracker服务器地址
//        //3、加载配置文件
//        ClientGlobal.init("D:\\IDEAL\\IDEAL-MANAGER-WEB\\src\\main\\resources\\client.conf");
//        //4、创建一个TrackerClient对象。
//        TrackerClient trackerClient = new TrackerClient();
//        //5、使用TrackerClient对象获得trackerserver对象。
//        TrackerServer trackerServer = trackerClient.getConnection();
//        //6、创建一个StorageServer的引用null就可以。
//        StorageServer storageServer = null;
//        //7、创建一个StorageClient对象。trackerserver、StorageServer两个参数。
//        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//        //8、使用StorageClient对象上传文件。
//        String[] strings = storageClient.upload_file("C:\\Users\\XINER\\Desktop\\88.png", "jpg", null);
//        for (String string : strings) {
//            System.out.println(string);
//
//        }
//
//    }
//
   @Test
    public void FastDfsClient() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("D:\\workspace\\2019_1_20\\IDEAL\\IDEAL\\IDEAL-MANAGER-WEB\\src\\main\\resources\\client.conf");
        String string = fastDFSClient.uploadFile("C:\\Users\\任章哲\\Desktop\\43.jpg");
        System.out.println(string);
    }
}
