package cn.ideal.manager.controller;

import cn.ideal.common.pojo.CommodityCart;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.utils.CookieUtils;
import cn.ideal.common.utils.JsonUtils;
import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class CartController {


    private static long addressFlag = 0 ;
    private static String cookieName = "cartList";
    private List<CommodityCart> getCartListFromCookie(HttpServletRequest httpServletRequest){
         String json = CookieUtils.getCookieValue(httpServletRequest,cookieName,true);
         if(StringUtils.isNullOrEmpty(json)){
             return new ArrayList();
         }
        List<CommodityCart> list = JsonUtils.jsonToList(json,CommodityCart.class);
         return list;
    }
    /*private List<UserAddress> getUserAddressListFromCookie(HttpServletRequest httpServletRequest){
        String json = CookieUtils.getCookieValue(httpServletRequest,"userAddress",true);
        if(StringUtils.isNullOrEmpty(json)){
            return new ArrayList();
        }
        List<UserAddress> list = JsonUtils.jsonToList(json,UserAddress.class);
        return list;
    }*/

    @RequestMapping("cart/getCartList/cartManager.do")
    @ResponseBody
    public MessageResult getCartList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //首页将商品添加到购物车时，添加商品，此处模拟
        List<CommodityCart> cookieList = new ArrayList<>();
        Integer id =1;
        Integer num =2;
        Integer price = 1;
        CommodityCart commodityCart = new CommodityCart(id.longValue(),"小米",num.longValue(),price.longValue(),"//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg");
        Integer nId = 2;
        Integer nnum = 1;
        Integer nprice = 1;
        CommodityCart commodityCart1 = new CommodityCart(nId.longValue(),"华硕",nnum.longValue(),nprice.longValue(),"//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg");
        cookieList.add(commodityCart);
        cookieList.add(commodityCart1);
        CookieUtils.setCookie(httpServletRequest,httpServletResponse,cookieName,JsonUtils.objectToJson(cookieList),604800,true);
        //从cookie中取出购物车列表
        List<CommodityCart> list = getCartListFromCookie(httpServletRequest);
        return MessageResult.ok(list);
    }
    @RequestMapping("cart/deleteComFromCookie/cartManager.do")
    @ResponseBody
    public MessageResult deleteComFromCookie(String id,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        String[] idArray = id.split(",");
        //从cookie拿出数据
       List<CommodityCart> list = getCartListFromCookie(httpServletRequest);
       for(int i=0;i<idArray.length;i++){
           //判断删除相应的数据
           Iterator<CommodityCart> iterator = list.iterator();
           while(iterator.hasNext()){
               CommodityCart commodityCart = iterator.next();
               if(commodityCart.getId()==Long.valueOf(idArray[i])){
                   iterator.remove();   //注意这个地方
               }
           }
       }
        //将剩余的设置Cookie
        CookieUtils.setCookie(httpServletRequest,httpServletResponse,cookieName,JsonUtils.objectToJson(list),604800,true);
        //从cookie中取出购物车列表,返回到前端，重新加载网页
        List<CommodityCart> cartList = getCartListFromCookie(httpServletRequest);
        return MessageResult.ok(cartList);
    }
    @RequestMapping("order/getComFromCookieById/orderManager.do")
    @ResponseBody
    public MessageResult getComFromCookieById(String idList,String numList,HttpServletRequest httpServletRequest){
        String[] IDList = idList.split(",");
        String[] NUMList = numList.split(",");
        //从cookie拿出数据
        List<CommodityCart> list = getCartListFromCookie(httpServletRequest);
        System.out.println("***********!!!!!!!!!!!!cookie中的商品："+IDList[0]);
        System.out.println(IDList.length);
        List<CommodityCart> finalList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
           for(int j=0;j<IDList.length;j++){
               if(list.get(i).getId()==Long.valueOf(IDList[j])){
                   list.get(i).setNum(Long.valueOf(NUMList[j]));
                   System.out.println("执行了："+list.get(j));
                   finalList.add(list.get(i));
                   System.out.println("!!!!!!!!!!"+finalList);
               }
           }
        }
        System.out.println("查到的list:"+finalList);
        return MessageResult.ok(finalList);
    }
   /* @RequestMapping("cart/setAddress/cartManager.do")
    @ResponseBody
    public MessageResult insertAddress(CommodityAddress commodityAddress){
        MessageResult messageResult = cartService.insertAddress(commodityAddress);
        return messageResult;
    }
    @RequestMapping("cart/getAddressList/cartManager.do")
    @ResponseBody
    public MessageResult getAddressList(){
        MessageResult messageResult= cartService.getAddressList();
        return messageResult;
    }
    @RequestMapping("cart/deleteAddressList/cartManager.do")
    @ResponseBody
    public MessageResult deleteAddressList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        CookieUtils.deleteCookie(httpServletRequest,httpServletResponse, "userAddress");
        return MessageResult.ok();
    }*/

}
