<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<h1>BBN-Service</h1>
<h2>Overview</h2>
<p>The <strong>bbn service app</strong> is an application that was originally meant to serve as a backend api for the <a href="https://github.com/monsur4/BBN"> demo
    bbn android application.</a> However, the application provides support to both web and android applications to query endpoints to create an account, login,
    authenticate user and admin, and allow manipulation of data.</p>

<ul>
    <li>Key Application features</li>
</ul>

<ol>
    <li>Functional Requirements</li>
    <ul>
        <li>Creation of contestant details by admin</li>
        <li>Fetching contestant(s) details</li>
        <li>Updating contestant details by admin</li>
        <li>Deletion of contestant details by admin</li>
    </ul>
    <li>Additional Requirements</li>
    <ul>
        <li>Creation of user account</li>
        <li>Creation of admin account</li>
        <li>Authentication of user and admin</li>
    </ul>
</ol>

<h2>Technology Stack</h2>
<ul>
    <li>Java</li>
    <li>Maven</li>
    <li>Mongodb</li>
    <li>Google cloud platform</li>
</ul>

<h2>Framework and Plugins</h2>
<ul>
    <li>Spring</li>
    <li>Springboot</li>
    <li>Spring security</li>
    <li>Spring mvc</li>
    <li>Project Lombok</li>
    <li>AppEngine</li>
</ul>

<h2>API Endpoints</h2>
<ul>
    <li><a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants">Fetch all contestants</a></li>
    <li><a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants/id/6178126e651f976b9cfbcfa6">Fetch contestant by id</a></li>
    <li><a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants/tag/nini">Fetch contestant by tag</a></li>
    <li>Method: Post - <a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants">Create new contestant</a></li>
    <li>Method: Put - <a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants/id/{id}">Update an existing contestant</a></li>
    <li>Method: Delete - <a href="https://probable-analog-329407.oa.r.appspot.com/api/contestants/id/{id}">Delete a contestant</a></li>
</ul>

<h2>Setting up for Local Development and Testing</h2>
<ul>
<li>clone the project</li>
    

    git clone https://github.com/monsur4/BBN-Service.git
   


<li>build the project
    <ul>
        <li>use a suitable ide to clean and build the project or run <strong>mvn clean package</strong></li>
        <li>then run the project</li>
    </ul>
</li>
<li>to run tests</li>
    <ul>
        <li>navigate to the src/main/test directory</li>
        <li>run the ContestantControllerTests.class as a class test. <strong>It is important to not run the test methods individually as a test ordering has been set to simulate a typical use case.</strong></li>
        <li>or simply run the maven command: <strong>mvn clean test</strong></li>
    </ul>
</ul>
</div>

</body>
</html>
