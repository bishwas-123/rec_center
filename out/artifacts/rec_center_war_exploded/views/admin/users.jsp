<%@ include file="header.jsp" %>
<section class="user-section section-main-body">

    <div class="row">


<%--        <% request.getSession().setAttribute("msg","");%>--%>
        <div class="col-sm-1"></div>
        <div class="col-sm-4">
            <form id="punch-in-out"  method="post" action="${pageContext.request.contextPath}/checkin">
                <div class="form-group" style="width:50%;">
                    Enter User Id:
                    <input  id="userId-checkIn" name="userId" type="text" class="form-control" required="required"/>
                    <div class="button-container" style="margin-top:10px;">

                       <input id="checkin-user" href="#" class="button" type="submit" value="CheckIn/Out"/>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-2">
            <div id="clock"></div>

        </div>
        <div class="col-sm-4">




            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Display Board</h4>
                <p>
                    <label style="font-weight: bold;"><%=request.getSession().getAttribute("msg") != null ? request.getSession().getAttribute("msg") : "No Messages.."%></label>
                        <%request.getSession().setAttribute("msg","");%>
                    <label style="font-weight: bold;"><%=request.getSession().getAttribute("duration") != null ? request.getSession().getAttribute("duration") : ""%></label>

                </p>
                <hr>
                <p class="mb-0">mum rec center&copy; mum.edu</p>
            </div>

        </div>
    </div>

    <div class="container">


        <div class="row">
            <div class="panel panel-primary filterable">
                <div class="panel-heading">
                    <h3 class="panel-title">Checked In users</h3>
                    <div class="pull-right">
<%--                        <div class="container">--%>
<%--                                <div class="input-group">--%>
                                <span class="input-group-btn">
                                    <button id="checkin-search" class="btn btn-search btn-xs btn-filter" type="button"><i class="fa fa-search fa-fw"></i> Search</button>
                             </span>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <button class="btn btn-default btn-xs btn-filter"><i class="fas fa-search"></i> Filter</button>--%>
                    </div>
                </div>
                <table class="table">
                    <thead>
                    <tr class="filters">
                        <th><input type="text" class="form-control" placeholder="User id" disabled></th>
<%--                        <th><input type="text" class="form-control" placeholder="User id" disabled></th>--%>
                        <th><input type="text" class="form-control" placeholder="Full Name" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Phone" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Email" disabled></th>
                        <th><input type="text" class="form-control" placeholder="Check In Time" disabled></th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.users}" var="user">
                        <tr>
                            <td><c:out value="${user.userId}" /></td>
                            <td><c:out value="${user.fullName}" /></td>
                            <td><c:out value="${user.contact}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.checkInTime}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</section>
<!-- end of home page content-->
<%@include file="footer.jsp" %>
