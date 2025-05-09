# Project Topic

AI Tattoo Suggestions

### Problem Statement

I have been talking about getting a tattoo since I turned 18. I am currently 21 and still have not gotten one because I am very picky when deciding what I want
and I haven't found an idea that I have fallen in love with. There is a popular twitch streamer named DougDoug who has made a lot of funny projects involving AI.
Recently I learned that OpenAI, the developers of ChatGPT, have an API available where you can incorporate earlier ChatGPT models into your projects. I decided I
am going to create an application that uses AI to give you tattoo suggestions that you can save and view. I think this could be a useful tool for others who
struggle like I do when deciding to get a tattoo since it can help give ideas when you are totally clueless on what kind of tattoo you want, or it can give other
suggestions or tweaks to a design you already like. My end goal is to get a tatoo that my program suggested since I think that is a cool way to incorporate some
story and meaning behind a simple tattoo.

### Project Technologies/Techniques

- **Security / Authentication**
    - AWS Cognito

- **Database**
    - MySQL 8.x

- **ORM Framework**
    - Hibernate 6.x

- **Dependency Management**
    - Maven

- **Web Services**
    - Consumes OpenAI API (model: `gpt-3.5-turbo`)

- **CSS Framework**
    - Bootstrap

- **Logging**
    - Log4J2

- **Hosting / Deployment**
    - AWS (EC2 or Elastic Beanstalk, etc.)

- **Unit Testing**
    - JUnit

- **IDE**
    - IntelliJ IDEA


### Main Features

  - Ability to register and sign in to a user account
  - A chat to interact with the AI and view the AI's responses
  - A button that allows you to save a given suggestion
  - A list of styles that you can save along with your suggestion
  - Ability to delete previously saved suggestions
  - Admin view of all registered users and their username
  - Admin ability to delete a given registered user
