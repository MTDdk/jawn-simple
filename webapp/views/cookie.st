<section>
    Showcase cookie handling
    <form action="/cookie/cookie" method="post">
    	<div class="form-group">
    		<input type="text" class="form-control" name="name">
    		<input type="text" class="form-control" name="value">
    	</div>
    	<button type="submit" class="btn btn-info">Submit</button>
    </form>
    $if(cookies)$
    Already set cookies:
    $cookies:{cookie | <div>$cookie.name$   +  $cookie.value$</div>}$
    $endif$
</section>