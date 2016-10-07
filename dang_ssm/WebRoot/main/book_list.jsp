<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="../css/book.css" rel="stylesheet" type="text/css" />
		<link href="../css/second.css" rel="stylesheet" type="text/css" />
		<link href="../css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="../css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="../images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='main.jsp'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>商品展示</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class="second_l_border2">
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										&middot;全部&nbsp;(${countNumOfBook}本)
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类开始-->
							<c:forEach items="${book2s}" var="book">							
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei>
											<a class="second_fenlei_a" 
											href="bookList.do?catId=${book.id }">
												${book.productName}&nbsp;(${book.productNum}本)
											</a>
										</div>
									</div>
								</li>							    
								<div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<c:if test="%{book2s.size()==0}">
					<p class="meiyoushangjia" >
						图书还没有上架！
					</p>
				</c:if>
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="desc">
								按上架时间降序
							</option>
							<option value="asc">
								按上架时间升序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<a href="bookList.do?currentPage=1">首页</a>
							<c:choose>
						         <c:when test="${page.currentPage==1}">
						             <a href="#">上一页</a>
						         </c:when>
						         <c:otherwise>
						             <a href="bookList.do?currentPage=${page.currentPage-1}">上一页</a>
						         </c:otherwise>
                            </c:choose>
                            
	                        <c:choose>
						         <c:when test="${page.currentPage==totalPage}">
						             <a href="#">下一页</a>
						         </c:when>
						         <c:otherwise>
						             <a href="bookList.do?currentPage=${page.currentPage+1}">下一页</a>
						         </c:otherwise>
                            </c:choose>
                         <a href="bookList.do?currentPage=${totalPage}">末页</a>
                         <div class='list_r_title_text3b' align="center">
								&nbsp&nbsp&nbsp第${page.currentPage}页/共${totalPage}页 &nbsp&nbsp&nbsp
						 </div>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
					<c:forEach items="${book1s}" var="book">	
						<div class="list_r_line"></div>
						<div class="clear"></div>

						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='bookDetail.do?bookId=${book.id }'>
								<img src="../productImages/${book.id}.jpg" /> </a> </span>
							<h2>
								书的名称：<a name="link_prd_name" href='bookDetail.do?bookId=${book.id }'>${book.productName }</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者：
								<a href='#' name='作者'>${book.author }</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>${book.publishing }</a>
							</h4>
							<h4>
								出版时间:
								${book.publishTime}
							</h4>
							<h5>
								书本描述：${book.description}
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${book.fixedPrice}</span>
								<span class="red">￥${book.dangPrice}</span>
								节省：￥${book.fixedPrice-book.dangPrice}元
							</h6>
							<span class="list_r_list_button"> 
							<a href="javascript:;" class="buy_a" onclick="buy('${book.productName}','${book.description}','${book.addTime}','${book.fixedPrice}','${book.dangPrice}','${book.productNum}');"> 
							   <img src='../images/buttom_goumai.gif' /> 
							</a>
							<span class="cartinfo" id="sp${book.productName}"></span></span>
							
						</div>

						
						</c:forEach>
						
						<!--商品条目结束-->
						<script type="text/javascript">
								function buy(productName,description,addTime,fixedPrice,dangPrice,productNum){
									$.ajax({
										url:"/dang_ssm/cart/buy.do",
										data:{"productName":productName,"description":description,"addTime":addTime,"fixedPrice":fixedPrice,"dangPrice":dangPrice},
										dataType:"text",
										type:"post",
										success:function(data){
											if(data=="success"){
												$("#sp"+productName).html("成功添加该商品到购物车");
											}else if(data=="denglu"){
												$("#sp"+productName).html("登陆才能添加到购物车");
												$("#sp"+productName).append('<a href="../user/login_form.jsp">请用户登陆</a>');
											}else{
												$("#sp"+productName).html("商品已经在购物车里面");
											}
										}
									});
								}
						</script>

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>
				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
