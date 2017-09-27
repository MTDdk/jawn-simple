<section>
    <form action="/upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="inputImage">Upload a picture <small>(nothing is saved on the server)</small></label>
            <input type="file" class="form-control" id="inputImage" name="image" accept="image/*">
        </div>
        <button type="submit" class="btn btn-default">Upload</button>
    </form>
    
    $if(picture)$
    <p></p>
    <div class="panel panel-default">
    <div class="panel-body" style="text-align:center;">
    <img src="$picture$" class="img-rounded">
    </div></div>
    $endif$
</section>