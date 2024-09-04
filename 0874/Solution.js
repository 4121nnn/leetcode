/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    const HASH_MULTIPLIER = 60001;
    const hashCoordinates = (x, y) => {
        return x + y * HASH_MULTIPLIER;
    };
    const obs = new Set(obstacles.map(obstacle => hashCoordinates(obstacle[0], obstacle[1])));
    let max = 0, x = 0, y = 0, dir = 0;
    let dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    
    for(let command of commands){
        if(command == -1){
            dir = (dir + 1) % 4;
        }else if(command == -2){
            dir = (dir + 3) % 4;
        }else{
            while(command-- > 0){
                let newX = x + dirs[dir][0];
                let newY = y + dirs[dir][1];

                if(obs.has(hashCoordinates(newX, newY)))
                    break;
                
                x = newX, y = newY;
        
            }
        }
        max = Math.max(max, x * x + y * y);
    }
    return max;
};
