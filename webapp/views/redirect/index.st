<section>
  <div class="jumbotron">
    <h3>$title$</h3>
    <h5>$message$</h5>

    <div class="row">
      <div class="col-lg-7">
        <form action="/redirect" method="post">
          <div class="input-group">
            <span class="input-group-addon" id="basic-addon1">URL</span>
            <input id="index_text_url" name="url" type="text" class="form-control" placeholder="http://github.com">
            <span class="input-group-btn">
              <button id="index_button_go" class="btn btn-default" type="submit">Go!</button>
            </span>
          </div>
          <!-- /input-group -->
        </form>
      </div>
      <!-- /.col-lg-6 -->
    </div>
    <!-- /.row -->
  </div>

</section>