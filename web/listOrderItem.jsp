<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${!empty user}">
	<div>
	<h1 align='center'>${user.name}的购物车</h1>
	</div>
</c:if>

<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>商品小计</td>
	</tr>
	
	<c:forEach items="${ois}" var="oi" varStatus="st">
	<tr>
		<td>${oi.product.name}</td>
		<td>${oi.product.price}</td>
		<td>${oi.num}</td>
		<td>${oi.product.price*oi.num}</td><br />
		</tr>
	</c:forEach>
	
	<c:if test="${!empty ois}">
		<tr>
			<td colspan="4" align="right">
				<a href="creatOrder">生成订单</a>
			</td>
		</tr>
	</c:if>
	
</table>