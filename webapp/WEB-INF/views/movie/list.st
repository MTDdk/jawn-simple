<section>
    <table class="table table-striped">
        <thead><tr><th>Name</th><th>Year</th></tr></thead>
        
        <tbody>
            $movies:{movie | <tr><td>$movie.name$</td><td>$movie.year$</td></tr>}$
        </tbody>
    </table>
</section>