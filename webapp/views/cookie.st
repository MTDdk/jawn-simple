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
    $cookies:{cookie | <div>$cookie.name$   +  $cookie.value$ +  $cookie.maxAge$ + $cookie.expires$</div>}$
    
    <form action="/cookie/cookies" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <button id="delete-cookies" class="btn btn-warning">Delete all cookies</button>
    </form>
    $endif$
</section>