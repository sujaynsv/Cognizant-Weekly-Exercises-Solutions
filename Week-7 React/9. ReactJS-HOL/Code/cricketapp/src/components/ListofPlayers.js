import React from 'react';

const ListofPlayers = () => {
    // Array of 11 players with names and scores
    const players = [
        { name: 'Virat Kohli', score: 85 },
        { name: 'Rohit Sharma', score: 92 },
        { name: 'KL Rahul', score: 65 },
        { name: 'Shikhar Dhawan', score: 78 },
        { name: 'Rishabh Pant', score: 45 },
        { name: 'Hardik Pandya', score: 60 },
        { name: 'Ravindra Jadeja', score: 72 },
        { name: 'Jasprit Bumrah', score: 30 },
        { name: 'Mohammed Shami', score: 25 },
        { name: 'Yuzvendra Chahal', score: 40 },
        { name: 'Ishan Kishan', score: 88 }
    ];

    // Filter players with scores below 70 using arrow function
    const lowScorers = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>All Players</h2>
            <ul>
                {/* Map through players array */}
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name}: {player.score}
                    </li>
                ))}
            </ul>

            <h2>Players with Scores Below 70</h2>
            <ul>
                {/* Map through filtered players */}
                {lowScorers.map((player, index) => (
                    <li key={index}>
                        {player.name}: {player.score}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ListofPlayers;