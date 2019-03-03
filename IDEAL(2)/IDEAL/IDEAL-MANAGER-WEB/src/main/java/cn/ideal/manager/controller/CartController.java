package cn.ideal.manager.controller;

import cn.ideal.common.pojo.CommodityCart;
import cn.ideal.common.pojo.UserAddress;
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
import java.util.UUID;

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
    private List<UserAddress> getUserAddressListFromCookie(HttpServletRequest httpServletRequest){
        String json = CookieUtils.getCookieValue(httpServletRequest,"userAddress",true);
        if(StringUtils.isNullOrEmpty(json)){
            return new ArrayList();
        }
        List<UserAddress> list = JsonUtils.jsonToList(json,UserAddress.class);
        return list;
    }

    @RequestMapping("cart/getCartList/cartManager.do")
    @ResponseBody
    public MessageResult getCartList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //首页将商品添加到购物车时，添加商品，此处模拟
        List<CommodityCart> cookieList = new ArrayList<>();
        Integer id =1;
        Integer num =2;
        Integer price = 2999;
        CommodityCart commodityCart = new CommodityCart(id.longValue(),"小米",num.longValue(),price.longValue(),"//i1.mifile.cn/a1/pms_1510291188.31088548!80x80.jpg");
        Integer nId = 2;
        Integer nnum = 1;
        Integer nprice = 777;
        CommodityCart commodityCart1 = new CommodityCart(nId.longValue(),"华硕",nnum.longValue(),nprice.longValue(),"");
        cookieList.add(commodityCart);
        cookieList.add(commodityCart1);
        CookieUtils.setCookie(httpServletRequest,httpServletResponse,cookieName,JsonUtils.objectToJson(cookieList),604800,true);
        //从cookie中取出购物车列表
        List<CommodityCart> list = getCartListFromCookie(httpServletRequest);
        return MessageResult.ok(list);
    }
    @RequestMapping("cart/deleteComFromCookie/cartManager.do")
    @ResponseBody
    public MessageResult deleteComFromCookie(Long id,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //从cookie拿出数据
       List<CommodityCart> list = getCartListFromCookie(httpServletRequest);
       //判断删除相应的数据
        Iterator<CommodityCart> iterator = list.iterator();
        while(iterator.hasNext()){
            CommodityCart commodityCart = iterator.next();
            if(commodityCart.getId()==id){
                iterator.remove();   //注意这个地方
            }
        }
       System.out.println("*******************"+list.size());
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
        List<CommodityCart> finalList = new ArrayList<>();
        for(int i=0;i<IDList.length;i++){
            if(list.get(i).getId()==Long.valueOf(IDList[i])){
                list.get(i).setNum(Long.valueOf(NUMList[i]));
                finalList.add(list.get(i));
            }
        }
        System.out.println("*****************"+finalList);
        return MessageResult.ok(finalList);
    }
    @RequestMapping("cart/setAddress/cartManager.do")
    @ResponseBody
    public MessageResult setAddress(UserAddress userAddress,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        System.out.println("**************!!!!!!!"+userAddress);
        List<UserAddress> oldList = getUserAddressListFromCookie(httpServletRequest);

        System.out.println("************************SIZE:::"+oldList.size());
        for(int i=0;i<oldList.size();i++){
            if(oldList.get(i).getAddress().equals(userAddress.getAddress())&&
                        oldList.get(i).getAddressTag().equals(userAddress.getAddressTag())&&
                        oldList.get(i).getDetailAddress().equals(userAddress.getDetailAddress())&&
                        oldList.get(i).getPhone().equals(userAddress.getPhone())&&
                        oldList.get(i).getUserName().equals(userAddress.getUserName())&&
                        oldList.get(i).getZipCode().equals(userAddress.getZipCode())){
                    return MessageResult.ok("该地址已存在");
            }
        }
        System.out.println("******************IIDD:"+userAddress.getId());
        if(userAddress.getId()!=null){
            if(oldList.size()!=0) {
                Iterator<UserAddress> iterator = oldList.iterator();
                while (iterator.hasNext()) {
                    UserAddress userAddress1 = iterator.next();
                    if (userAddress.getId().equals(userAddress1.getId())) {
                        System.out.println("******删除" + userAddress1);
                        iterator.remove();
                    }
                }
            }
        }
        String id = UUID.randomUUID().toString();
        userAddress.setId(id);
        oldList.add(userAddress);
        System.out.println("**************!!!!!!!oldList:"+oldList);
        CookieUtils.setCookie(httpServletRequest,httpServletResponse,"userAddress",JsonUtils.objectToJson(oldList),604800,true);
        List<UserAddress> list = getUserAddressListFromCookie(httpServletRequest);
        System.out.println("***********!!!!!!!return :"+list);
        return MessageResult.ok(oldList);
    }
    @RequestMapping("cart/getAddressList/cartManager.do")
    @ResponseBody
    public MessageResult getAddressList(HttpServletRequest httpServletRequest){
        List<UserAddress> list = getUserAddressListFromCookie(httpServletRequest);
        return MessageResult.ok(list);
    }
    @RequestMapping("cart/deleteAddressList/cartManager.do")
    @ResponseBody
    public MessageResult deleteAddressList(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        CookieUtils.deleteCookie(httpServletRequest,httpServletResponse, "userAddress");
        return MessageResult.ok("删除成功");
    }
    /*@RequestMapping("cart/editAddressList/cartManager.do")
    @ResponseBody
    public MessageResult editAddressList(UserAddress userAddress,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        addressFlag++;
        userAddress.setId(addressFlag);
        System.out.println("*********************!!!!!!!!!!!!!"+userAddress);
        List<UserAddress> oldList = getUserAddressListFromCookie(httpServletRequest);
        //判断删除相应的数据
        Iterator<UserAddress> iterator = oldList.iterator();
        while(iterator.hasNext()){
            UserAddress userAddress1 = iterator.next();
            if(userAddress.getId()==userAddress1.getId()){
                System.out.println("******删除"+userAddress1);
                iterator.remove();
            }
        }
        oldList.add(userAddress);
        System.out.println("*******************!!!!!!!!!"+oldList);
        CookieUtils.setCookie(httpServletRequest,httpServletResponse,"userAddress",JsonUtils.objectToJson(oldList),604800,true);
        List<UserAddress> returnList = getUserAddressListFromCookie(httpServletRequest);
        return MessageResult.ok(returnList);
    }*/
}
