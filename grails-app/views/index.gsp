<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome!</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>
    <div class="nav" role="navigation">
        <sec:ifNotLoggedIn>
            <g:link controller='login' action='auth'>Login</g:link>
        </sec:ifNotLoggedIn>
        <sec:ifLoggedIn>
            <a>Hello, ${sec.username()}</a>
            <g:link elementId='logout' controller='logout'>Logout</g:link>
        </sec:ifLoggedIn>
    </div>
    </head>

<body>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome!</h1>

        <div id="controllers" role="navigation">
            <div class="list-group">

                <sec:ifAnyGranted roles='ROLE_ADMIN'>
                    <a href="./categories" class="list-group-item list-group-item-action">Categories</a>
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles='ROLE_CLIENT'>

                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles='ROLE_ADMIN, ROLE_CLIENT'>
                    <a href="./products" class="list-group-item list-group-item-action">Products</a>
                </sec:ifAnyGranted>
            </div>
        </div>
    </section>
</div>

</body>
</html>