A simple web service was created that returns 
you a random quiz from a large pool inside it,
there is also an answer to the question and many 
other parameters. By get request 
`api/quiz` or `api/quiz/{count}`
where count is the number of quizzes.

Docker build is done like this
`docker build . -t quizapp` 
and run `docker run -p 8081:8081 quizapp`