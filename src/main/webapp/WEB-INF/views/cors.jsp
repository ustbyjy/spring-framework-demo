<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cors Support</title>
</head>
<body>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<button class="bt">触发跨域1</button>
<br><br><br>
<button class="bt">触发跨域2</button>
<br><br><br>
<button class="bt">触发跨域3</button>

<script type="text/javascript" src="${ctx}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(".bt").click(function () {
        var index = $(".bt").index(this) + 1;
        $.ajax({
            type: "GET",
            url: "http://localhost:9095/cors/api" + index,
            success: function (data) {
                console.info(data);
            }
        })
    });
</script>
</body>
</html>
