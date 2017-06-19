<taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" />
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
    <div>
        <form action="${pageContext.request.contextPath}/updownload/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit" value="upload" />
        </form>
    </div>
</body>
</html>
