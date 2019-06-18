<%@include file="header.jsp"%>
<section class="section-main-body">

    <div class="row">


        <%--        <% request.getSession().setAttribute("msg","");%>--%>
        <div class="col-sm-2"></div>

        <div class="col-sm-8">

            <div class="alert alert-secondary" role="alert">
                <h4 class="alert-heading">Welcome Admin</h4>
                <p>

                    The MUM Recreation Center is a 60,000-square-foot indoor facility, one of the largest indoor university sports facilities in the state of Iowa.
                    <label style="font-weight: bold;"><%=request.getSession().getAttribute("msg") != null ? request.getSession().getAttribute("msg") : "No Messages.."%></label>
                    <%request.getSession().setAttribute("msg","");%>

                </p>
                <hr>
                <p class="mb-0">mum rec center&copy; mum.edu</p>
            </div>
        </div>
        <div class="col-sm-2">

        </div>

    </div>


</section>
<%@include file="footer.jsp"%>