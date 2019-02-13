<section>
  <p class="lead">Showcase cookie handling</p>
  
  <div class="panel panel-default">
    <div class="panel-heading">Add a cookie:</div>
    <div class="panel-body">
      <form action="/cookie" method="post">
        <div class="form-group">
          <label for="cookiename">Cookie name</label>
          <input id="cookiename" type="text" class="form-control" name="name">
        </div>
        <div class="form-group">
          <label for="cookievalue">Cookie value</label>
          <input id="cookievalue" type="text" class="form-control" name="value">
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
      </form>
    </div>
  </div>
  
  $if(cookies)$
  <p></p>
  <div class="panel panel-default">
    <div class="panel-heading">Already set cookies:</div>
    <div class="panel-body">
      <ul>
      $cookies:{cookie |
      <li>$cookie.name$ + $cookie.value$ + $cookie.maxAge$</li>
      }$
      </ul>
    </div>
  </div>

  <form action="/cookie" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <button id="delete-cookies" class="btn btn-warning">Delete all cookies</button>
  </form>
  $endif$
</section>