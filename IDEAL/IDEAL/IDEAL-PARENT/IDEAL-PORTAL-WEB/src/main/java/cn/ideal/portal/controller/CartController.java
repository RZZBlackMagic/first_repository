package cn.ideal.portal.controller;

import cn.ideal.common.results.CartResult;
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

    private static String cookieName = "cartList";

    private List<CartResult> getCartListFromCookie(HttpServletRequest httpServletRequest) {
        String json = CookieUtils.getCookieValue(httpServletRequest, cookieName, true);
        if (StringUtils.isNullOrEmpty(json)) {
            return new ArrayList();
        }
        List<CartResult> list = JsonUtils.jsonToList(json, CartResult.class);
        return list;
    }


    @RequestMapping("cart/getCartList/cartManager.do")
    @ResponseBody
    public MessageResult getCartList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //从cookie中取出购物车列表*/
        List<CartResult> list = getCartListFromCookie(httpServletRequest);
        return MessageResult.ok(list);
    }

    @RequestMapping("cart/deleteComFromCookie/cartManager.do")
    @ResponseBody
    public MessageResult deleteComFromCookie(String id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String[] idArray = id.split(",");
        //从cookie拿出数据
        List<CartResult> list = getCartListFromCookie(httpServletRequest);
        for (int i = 0; i < idArray.length; i++) {
            //判断删除相应的数据
            Iterator<CartResult> iterator = list.iterator();
            while (iterator.hasNext()) {
                CartResult commodityCart = iterator.next();
                if (commodityCart.getId() == Long.valueOf(idArray[i])) {
                    iterator.remove();   //注意这个地方
                }
            }
        }
        //将剩余的设置Cookie
        CookieUtils.setCookie(httpServletRequest, httpServletResponse, cookieName, JsonUtils.objectToJson(list), 604800, true);
        //从cookie中取出购物车列表,返回到前端，重新加载网页
        List<CartResult> cartList = getCartListFromCookie(httpServletRequest);
        return MessageResult.ok(cartList);
    }

    @RequestMapping("order/getComFromCookieById/orderManager.do")
    @ResponseBody
    public MessageResult getComFromCookieById(String idList, String numList, HttpServletRequest httpServletRequest) {
        String[] IDList = idList.split(",");
        String[] NUMList = numList.split(",");
        //从cookie拿出数据
        List<CartResult> list = getCartListFromCookie(httpServletRequest);
        List<CartResult> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < IDList.length; j++) {
                if (list.get(i).getId() == Long.valueOf(IDList[j])) {
                    list.get(i).setNum(Integer.valueOf(NUMList[j]));
                    finalList.add(list.get(i));
                }
            }
        }
        return MessageResult.ok(finalList);
    }

    @RequestMapping("cart/getCommodityForCart/cartManager.do")
    @ResponseBody
    public MessageResult getCommodityForCart(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, CartResult cart) {
        List<CartResult> list = getCartListFromCookie(httpServletRequest);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == cart.getId()) {
                //商品已存在购物车,500表示商品已存在
                return MessageResult.ok(500);
            }
        }
        cart.setNum(1);
        list.add(cart);
        CookieUtils.setCookie(httpServletRequest, httpServletResponse, cookieName, JsonUtils.objectToJson(list), 604800, true);
        return MessageResult.ok(cart);
    }
}
