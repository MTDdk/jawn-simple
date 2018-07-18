<section>
  <p>Update the page multiple times to see that the movies get cached. After $number_of_seconds$ seconds of inactivity they should have been evicted from the cache,
  and they will start to be added to the cache again.</p>
  <div class="panel panel-default">
    <div class="panel-heading">Cache status of a random movie:</div>
    <div class="panel-body">
      <p><strong>$cache_message$</strong></p>
      $movie$
    </div>
  </div>
</section>