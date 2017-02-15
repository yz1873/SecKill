<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <title>秒杀商品列表</title>
  <%--动态包含，会解析完jsp后再合并--%>
  <%--静态包含，head.jsp会合并过来--%>
  <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
  <div class="panel panel-default">
    <div class="panel-heading text-center">
      <h2>秒杀列表</h2>
    </div>
    <div class="panel-body">
      <table class="table table-hover">
        <thead>
        <tr>
          <th>名称</th>
          <th>库存</th>
          <th>开始时间</th>
          <th>结束时间</th>
          <th>创建时间</th>
          <th>详情页</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="sk">
          <tr>
            <td>${sk.name}</td>
            <td>${sk.number}</td>
            <td>
              <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td>
              <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td>
              <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
            </td>
            <td><a class="btn btn-info" href="<%=request.getContextPath()%>/seckill/${sk.seckillId}/detail" target="_blank">详情</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </div>
</div>
<a style="display: block;text-align: center;font-size:18px" href="<%=request.getContextPath()%>/seckill/techview" target="_blank">查看秒杀系统的构成</a>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
