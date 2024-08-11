// app.js

// Function to test the API
async function testAPI() {
    const response = await fetch('http://localhost:8080/jupitermission/webapi/resource/test');
    const data = await response.text();
    document.getElementById('testResult').textContent = `Test Result: ${data}`;
}

// Function to create a plateau via POST
async function createPlateauWithRobot() {
    const plateauX = document.getElementById('plateauX').value;
    const plateauY = document.getElementById('plateauY').value;

    const robotX = document.getElementById('robotX').value;
    const robotY = document.getElementById('robotY').value;
    const robotDirection = document.getElementById('robotDirection').value;
    if (!plateauX || !plateauY || !robotX || !robotY || !robotDirection) {
        document.getElementById('plateauResult').textContent = 'Error: All fields must be filled out.';
        return;
    }

    const requestPayload = {
        plateau: {
            coordinateX: parseInt(plateauX, 10),
            coordinateY: parseInt(plateauY, 10),
            robot: {
            	coordinateX: parseInt(robotX, 10),
            	coordinateY: parseInt(robotY, 10),
            	direction: robotDirection
        	}
        }
    };

    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/resource/createplateau', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestPayload)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        let formattedResult;
        if (data.error) {
            formattedResult = `<strong>Error:</strong> ${data.error}`;
        } else {
        	formattedResult = `
            	<strong>Plateau:</strong> (${data.plateau.coordinateX}, ${data.plateau.coordinateY})<br/>
            	<strong>Robot:</strong> (${data.plateau.robot.coordinateX}, ${data.plateau.robot.coordinateY}) facing ${data.plateau.robot.direction}
        	`;
        }
        document.getElementById('plateauResult').innerHTML=formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('plateauResult').textContent = `Error: ${error.message}`;
    }
}

// Function to execute commands via POST
async function executeCommands() {
    const commands = document.getElementById('commands').value;
    if (!commands) {
        document.getElementById('commandsResult').textContent = 'Error: Please Enter Some Command.';
        return;
    }
    const requestPayload = {
        commands: commands
    };
    
    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/resource/executecommands', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestPayload)
        });
        
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        
        const data = await response.json();
        let formattedResult;
        if (data.error) {
            formattedResult = `<strong>Error:</strong> ${data.error}`;
        } else {
            formattedResult = `
                <strong>Commands Executed with New Position:</strong> (${data.robot.coordinateX}, ${data.robot.coordinateY}) facing ${data.robot.direction}
            `;
        }
        document.getElementById('commandsResult').innerHTML=formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('commandsResult').textContent = `Error: ${error.message}`;
    }
}



// Function to create a plateau via GET
async function createPlateauGet() {
    const x = document.getElementById('plateauX').value;
    const y = document.getElementById('plateauY').value;

    const response = await fetch(`http://localhost:8080/jupitermission/webapi/resource/createplateau/${x}/${y}`);
    const data = await response.json();
    document.getElementById('plateauGetResult').textContent = `Plateau Created (GET): ${JSON.stringify(data, null, 2)}`;
}

// Function to create a robot via POST
async function createRobot() {
    const robotX = document.getElementById('robotXX').value;
    const robotY = document.getElementById('robotYY').value;
    const robotDirection = document.getElementById('robotDirectionD').value;
    
    if (!robotDirection || !robotX || !robotY) {
        document.getElementById('robotResult').textContent = 'Error: Please Fill all the fields';
        return;
    }

    const requestPayload = {
        robot: {
            coordinateX: parseInt(robotX, 10),
            coordinateY: parseInt(robotY, 10),
            direction: robotDirection
        }
    };

    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/resource/createrobot', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestPayload)
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        let formattedResult;
        if (data.error) {
            formattedResult = `<strong>Error:</strong> ${data.error}`;
        } else {
        	formattedResult = `
            	<strong>Robot:</strong> (${data.robot.coordinateX}, ${data.robot.coordinateY}) facing ${data.robot.direction}
        	`;
        }
        document.getElementById('robotResult').innerHTML=formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('robotResult').textContent = `Error: ${error.message}`;
    }
}

