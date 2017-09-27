<section>
  <p class="lead">Upload a picture<br><small>(notice nothing is actually saved on the server)</small></p>
  <p></p>
  <form action="/upload" method="post" enctype="multipart/form-data">
    <div class="panel panel-default">
      <div class="panel-heading">
        <label for="inputImage">Pick an image</label>
      </div>
      <div class="panel-body">
        <div class="form-group">
          <input type="file" class="form-control" id="inputImage" name="image" accept="image/*" onchange="javascript:this.form.submit();">
        </div>
        <button type="submit" class="btn btn-default">Upload</button>
      </div>
    </div>
  </form>


  $if(picture)$
  <p></p>
  <div class="panel panel-default">
    <div class="panel-heading">Uploaded and converted to base64 data:</div>
    <div class="panel-body" style="text-align:center;">
    <img src="$picture$" class="img-rounded">
    </div></div>
  $endif$
</section>