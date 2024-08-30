// Function to create a plateau via POST
async function createPlateau() {
    const plateauX = document.getElementById('plateauX').value;
    const plateauY = document.getElementById('plateauY').value;

    if (!plateauX || !plateauY) {
        document.getElementById('plateauResult').textContent = 'Error: Plateau coordinates must be filled out.';
        return;
    }

    const plateauPayload = {
        upperX: parseInt(plateauX, 10),
        upperY: parseInt(plateauY, 10)
    };

    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/api/plateau', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(plateauPayload)
        });

        if (!response.ok) {
            const data = await response.json();
            throw new Error(data.message);
        }

        const data = await response.json();
        let formattedResult;
        if (data.success) {
            formattedResult = `<strong>Plateau:</strong> (${data.data.upperX}, ${data.data.upperY})`;
        } else {
            formattedResult = `<strong>Error:</strong> ${data.message}`;
        }
        document.getElementById('plateauResult').innerHTML = formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('plateauResult').textContent = `Error: ${error.message}`;
    }
}

// Function to create a robot via PUT
async function createRobot() {
    const robotX = document.getElementById('robotX').value;
    const robotY = document.getElementById('robotY').value;
    const robotDirection = document.getElementById('robotDirection').value;

    if (!robotX || !robotY || !robotDirection) {
        document.getElementById('robotResult').textContent = 'Error: All robot fields must be filled out.';
        return;
    }

    const robotPayload = {
        coordinateX: parseInt(robotX, 10),
        coordinateY: parseInt(robotY, 10),
        direction: robotDirection
    };

    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/api/robots', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(robotPayload)
        });

        if (!response.ok) {
            const data = await response.json();
            throw new Error(data.message);
        }

        const data = await response.json();
        let formattedResult;
        if (data.success) {
            formattedResult = `
                <strong>Robot:</strong> (${data.data.coordinateX}, ${data.data.coordinateY}) facing ${data.data.direction}
            `;
        } else {
            formattedResult = `<strong>Error:</strong> ${data.message}`;
        }
        document.getElementById('robotResult').innerHTML = formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('robotResult').textContent = `Error: ${error.message}`;
    }
}

// Function to execute commands via PUT
async function executeCommands() {
    const commands = document.getElementById('commands').value;
    if (!commands) {
        document.getElementById('commandsResult').textContent = 'Error: Please Enter Some Command.';
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/jupitermission/webapi/api/robots/move', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(commands)
        });

        if (!response.ok) {
            const data = await response.json();
            throw new Error(data.message);
        }

        const data = await response.json();
        let formattedResult;
        if (data.success) {
            const position = data.data;
            formattedResult = `
                <strong>Commands Executed with New Position:</strong> ${position}
            `;
        } else {
            formattedResult = `<strong>Error:</strong> ${data.message}`;
        }
        document.getElementById('commandsResult').innerHTML = formattedResult;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('commandsResult').textContent = `Error: ${error.message}`;
    }
}
