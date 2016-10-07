<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/shopping_vehicle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	</head>
	<body>
		<br/>
		<br/>
		<div class="my_shopping">
			<img class="pic_shop" src="../images/pic_myshopping.gif" />
		</div>
		<div id="div_choice" class="choice_merch">
			<h2 id="cart_tips">
				您已选购以下商品
			</h2>
			<div class="choice_bord">
				<table class="tabl_buy" id="tbCartItemsNormal">
					<tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_2">
							<span>更改数量</span>
						</td>
						<td class="buy_td_1">
							<span>删除</span>
						</td>
					</tr>
					<tr class='objhide' over="no">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
                      <!-- 购物列表开始 -->
                      	<c:forEach items="${products}" var="product">
							<tr class='td_no_bord'>
								<td style='display: none;'>
									9317290
								</td>
								<td class="buy_td_6">
									<span class="objhide"><img /> </span>
								</td>
								<td class="span_w1">
									<a href="#">${product.productName }</a>
								</td>
								<td class="buy_td_5">
									<span class="c_gray">￥${product.fixedPrice}</span>
								</td>
								<td class="buy_td_4">
									&nbsp;&nbsp;
									<span>￥${product.dangPrice}</span>
								</td>
								<td class="buy_td_1">
									&nbsp;&nbsp;${product.productNum}
								</td>
	
								<td >
									<input class="del_num" type="text" size="3" maxlength="4" id="txt${product.id }"/>
									<a href="javascript:;" onclick="change(${product.id },'txt${product.id }');">更改</a>
								</td>
								<td>
									<a href="../cart/deleteCartItem.do?productId=${product.id}">删除</a>
								</td>
							</tr>
						</c:forEach>
					<!-- 购物列表结束 -->
				</table>
				
				<script type="text/javascript">
					function change(pId,txtId){
						var v=$.trim($('#'+txtId).val());
						var reg=/^\d+$/;
						if(! reg.test(v)){
							alert('只能输入数字');
							return;
						}
						if(v<1){
							alert('数字要大于1');
							return;
						}
						location='updateCartItem.do?productId='+pId+'&quantity='+v;
					}
				</script>
				
				<div class="total_balance">
						<div class="save_total">
							您共节省：
							<span class="c_red"> ￥<span id="total_economy">${totalSave}</span>
							</span>
							<span id='total_vip_economy' class='objhide'> ( 其中享有优惠： <span
								class="c_red"> ￥<span id='span_vip_economy'>0.00</span> </span>
								) </span>
							<span style="font-size: 14px">|</span>
							<span class="t_add">商品金额总计：</span>
							<span class="c_red_b"> ￥<span id='total_account'>${totalCost}</span>
							</span>
						</div>
						<div id="balance" class="balance">
							<a name='checkout' href='../order/orderInfo.do' > 
								<img src="../images/butt_balance.gif" alt="结算" border="0" title="结算" />
							</a>
							<br /> 
							<input type="button" id="save_cart_btn" value="保存购物车" onclick="saveCart();"  />
							<br/>
							<span class="save_cart"></span>
							<script type="text/javascript">
								function saveCart(){
									$.ajax({
										    url:"/dang_ssm/cart/saveCart.do",
											dataType:"text",
											type:"post",
											success:function(data){
												if(data=="success"){
													$(".save_cart").html("保存成功");
													$("#save_cart_btn").attr("disabled","disabled");
												}else{
													$(".save_cart").html("保存失败，请稍后重试");
												}
											}});
								}
							</script>
						</div>
					</div>
				<!--没有挑选商品 -->
				<c:if test="${products.size()==0}">			
					<div id="div_no_choice" class="objhide1">
						<div class="choice_title"></div>
						<div class="no_select">
							您还没有挑选商品
						</div>
					</div>
				</c:if>
				<!--没有挑选商品 -->	
				<div class="choice_balance">
					<div class="select_merch">
						<a href='../main/bookList.do'> 继续挑选商品
						(回到购物主页)>></a>
					</div>					
				</div>
			</div>
		<!-- 用户删除恢复区 -->
		
		<div id="divCartItemsRemoved" class="del_merch">
			<div class="del_title">
				您已删除以下商品，如果想重新购买，请点击下面恢复按钮
			</div>
			<table class="tabl_del" id="del_table">
				<tbody>
				    <tr class="tabl_buy_title">
						<td class="buy_td_6">
							<span>&nbsp;</span>
						</td>
						<td>
							<span class="span_w1">商品名</span>
						</td>
						<td class="buy_td_5">
							<span class="span_w2">市场价</span>
						</td>
						<td class="buy_td_4">
							<span class="span_w3">当当价</span>
						</td>
						<td class="buy_td_1">
							<span class="span_w2">数量</span>
						</td>
						<td class="buy_td_1">
							<span>恢复与否</span>
						</td>
					</tr>
					<!-- 列表开始 -->
					<c:forEach items="${deleteListCart}" var="product">
						<tr>
							<td style='display: none;'>
									9317290
								</td>
								<td class="buy_td_6">
									<span class="objhide"><img /> </span>
								</td>
								<td class="span_w1">
									<a href="#">${product.productName }</a>
								</td>
								<td class="buy_td_5">
									<span class="c_gray">￥${product.fixedPrice}</span>
								</td>
								<td class="buy_td_4">
									&nbsp;&nbsp;
									<span>￥${product.dangPrice}</span>
								</td>
								<td class="buy_td_1">
									&nbsp;&nbsp;${product.productNum }
								</td>
								<td>
									<a href="../cart/insert.do?productId=${product.id}">恢复</a>
								</td>
						</tr>
					</c:forEach>
					<!-- 列表结束 -->
					<tr class="td_add_bord">
						<td colspan="8">
							&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
   </div>
		<br />
		<br />
		<br />
		<br />
		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>



