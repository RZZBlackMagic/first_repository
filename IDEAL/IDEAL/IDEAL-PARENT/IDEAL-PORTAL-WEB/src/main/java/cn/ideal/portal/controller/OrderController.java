package cn.ideal.portal.controller;

import cn.ideal.common.pojo.CommodityAddress;
import cn.ideal.common.pojo.CommodityOrder;
import cn.ideal.common.pojo.CommodityOrderItem;
import cn.ideal.common.pojo.CommodityOrderShipping;
import cn.ideal.common.results.MessageResult;
import cn.ideal.common.utils.PaymentUtil;
import cn.ideal.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("order1/getComFromCookieById/orderManager.do")
    @ResponseBody
    public MessageResult getComFromCookieById(String idList, String numList){
        MessageResult messageResult = orderService.getComFromCookieById(idList,numList);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrder/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrder(CommodityOrder commodityOrder){
        MessageResult messageResult = orderService.insertIntoCommodityOrder(commodityOrder);
        return messageResult;
    }
    @RequestMapping("order/updateCommodityOrder/orderManager.do")
    @ResponseBody
    public MessageResult updateCommodityOrder(String id, String shippingCode, String shippingName){
        MessageResult messageResult = orderService.updateCommodityOrder(id,shippingCode,shippingName);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrderItem/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrderItem(CommodityOrderItem commodityOrderItem){
        MessageResult messageResult = orderService.insertIntoCommodityOrderItem(commodityOrderItem);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityOrderShipping/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityOrderShipping(CommodityOrderShipping commodityOrderShipping){
        MessageResult messageResult = orderService.insertIntoCommodityOrderShipping(commodityOrderShipping);
        return messageResult;
    }
    @RequestMapping("order/getAddressList/orderManager.do")
    @ResponseBody
    public MessageResult getAddressList(Long userId){
        MessageResult messageResult = orderService.getAddressList(userId);
        return messageResult;
    }
    @RequestMapping("order/insertIntoCommodityAddress/orderManager.do")
    @ResponseBody
    public MessageResult insertIntoCommodityAddress(CommodityAddress commodityAddress){
        MessageResult messageResult = orderService.insertIntoCommodityAddress(commodityAddress);
        return messageResult;
    }
    @RequestMapping("order/getOrderInfo/orderManager.do")
    @ResponseBody
    public MessageResult getOrderInfo(String orderId){
        MessageResult messageResult = orderService.getOrderInfo(orderId);
        return messageResult;
    }
    @RequestMapping("order/turnToCallBack/orderManager.do")
    @ResponseBody
    public MessageResult callback(HttpServletRequest request, HttpServletResponse response,String orderId) throws Exception{
        /*String p1_MerId = request.getParameter("p1_MerId");
        String r0_Cmd = request.getParameter("r0_Cmd");
        String r1_Code = request.getParameter("r1_Code");
        String r2_TrxId = request.getParameter("r2_TrxId");
        String r3_Amt = request.getParameter("r3_Amt");
        String r4_Cur = request.getParameter("r4_Cur");
        String r5_Pid = request.getParameter("r5_Pid");
        String r6_Order = request.getParameter("r6_Order");
        String r7_Uid = request.getParameter("r7_Uid");
        String r8_MP = request.getParameter("r8_MP");
        String r9_BType = request.getParameter("r9_BType");
        String rb_BankId = request.getParameter("rb_BankId");
        String ro_BankOrderId = request.getParameter("ro_BankOrderId");
        String rp_PayDate = request.getParameter("rp_PayDate");
        String rq_CardNo = request.getParameter("rq_CardNo");
        String ru_Trxtime = request.getParameter("ru_Trxtime");
        // 身份校验 --- 判断是不是支付公司通知你
        String hmac = request.getParameter("hmac");
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString(
                "keyValue");

        // 自己对上面数据进行加密 --- 比较支付公司发过来hamc
        boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd,
                r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        if (isValid) {
            // 响应数据有效
            if (r9_BType.equals("1")) {
                // 浏览器重定向
                System.out.println("*************111");
                request.setAttribute("msg", "您的订单号为:"+r6_Order+",金额为:"+r3_Amt+"已经支付成功,等待发货~~");

            } else if (r9_BType.equals("2")) {
                // 服务器点对点 --- 支付公司通知你
                System.out.println("********付款成功！222");
                // 修改订单状态 为已付款
                // 回复支付公司
                response.getWriter().print("success");
            }


        } else {
            // 数据无效
            System.out.println("数据被篡改！");
        }*/
        //修改订单状态
        MessageResult messageResult = orderService.updateOrderStatus(orderId);


        return messageResult;

    }
    @RequestMapping("order/payForCommodity/orderManager.do")
    @ResponseBody
    public MessageResult pay(HttpServletRequest request, HttpServletResponse response,String oid,String pd_FrpId) throws Exception {


        // 组织发送支付公司需要哪些数据
        pd_FrpId = pd_FrpId;
        String p0_Cmd = "Buy";
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
        String p2_Order = "998028403889509829090809";
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
                p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

        // 发送给第三方
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);
        String url = sb.toString();
        System.out.println(url);


        return MessageResult.ok(url);
    }

}
