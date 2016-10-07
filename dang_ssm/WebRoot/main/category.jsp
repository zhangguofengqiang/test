<%@page contentType="text/html;charset=utf-8"%>

<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始--><s:debug></s:debug>
		<s:iterator value="%{catList}" var="cat">
				<div class="bg_old" onmouseover="this.className = 'bg_white';"
					onmouseout="this.className = 'bg_old';">
					<h3>
						[<a href='#'>${name }</a>]
					</h3>
					<ul class="ul_left_list">
	
							<!--2级分类开始-->
							<s:iterator value="%{subCats}" >
								<li>
									<a class="main_category_a" href='bookList.action?catId=${id }&parentId=${cat.id }'>${name }</a>
								</li>
								
							</s:iterator>
							<!--2级分类结束-->
	
					</ul>
					<div class="empty_left">
					</div>
				</div>
	
				<div class="more2">
				</div>
			</s:iterator>
			<!--1级分类结束-->
		


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
