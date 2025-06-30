Custom ScrumBoard

TO RUN THE PROJECT, YOU NEED TO CREATE A .env FILE IN THE PROJECT ROOT WITH THE FOLLOWING CONTENT:

DB_URL= URL for connecting to the database
DB_USERNAME= username for connecting to the database
DB_PASSWORD= password for connecting to the database
GH_CLIENT_ID= GitHub ID for connecting to GitHub
GH_CLIENT_SECRET= password for connecting to GitHub
GOOGLE_CLIENT_ID= client ID for connecting to Google
GOOGLE_CLIENT_SECRET= password for connecting to Google
GITLAB_CLIENT_ID= GitLab ID for connecting to GitLab
GITLAB_CLIENT_SECRET= password for connecting to GitLab
MAIL_HOST= host for email
MAIL_USERNAME= login for email
MAIL_PASSWORD= password for email

The dotenv-java library will automatically load these environment variables when the application starts.

After that run docker-compose up to start the DB using \
docker-compose build\
docker-compose up -d

When DB is up and running, you can run the application using: CustomScrumBoardApplication