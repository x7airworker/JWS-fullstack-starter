# JWS-fullstack-starter
A scaffold for you, to start your new fullstack project with. It uses [JavaWebStack](https://github.com/JavaWebStack) and Vite (Vue.3) to create a fullstack application which is comfortable to use while developing and also easy to deploy afterwards.

# How to use
- Create your new project with this template
- Run the run configuration `Build` or `mvn clean package` which will install node, dependencies and builds a fully deployable application.
- Run the run configuration `Start Backend` or launch the `Bootstrap` class to start up the backend
- Run the run configuration `Start Frontend` or `npm run dev` which will watch for all changes in the Vue sources

# IDE Recommendation
For the best expierence I recommend IntelliJ IDEA Ultimate, which has excellent support for Java, JavaScript and Vue

# I don't like Vue...
Just generate a new project using Vite in the `src/main/javascript/` directory using your preffered Frontend Framework and copy over the `package.json` scripts and `vite.config.js` configuration.