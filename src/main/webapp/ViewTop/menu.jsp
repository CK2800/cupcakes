<%@page import="jhc.presentation.FrontController"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="./">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cupcakes/FrontController?origin=<%= FrontController.CREATE_USER %>">Create user</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/cupcakes/FrontController?origin=<%= FrontController.LOGIN %>">Log in</a>
      </li>
    </ul>
  </div>
</nav>
