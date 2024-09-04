func robotSim(commands []int, obstacles [][]int) int {
    HASH_MULTIPLIER := 60001
    dirs := [][]int{{0,1}, {1,0}, {0, -1}, {-1, 0}}
    max, x, y, dir := 0, 0, 0, 0
    obs := make(map[int]struct{})

    var hashCoordinates func(x,y int) int
    hashCoordinates = func(x, y int) int {
        return x + y * HASH_MULTIPLIER
    }

    for _, o := range obstacles {
        obs[hashCoordinates(o[0], o[1])] = struct{}{}
    }

    for _, command := range commands{
        switch command {
            case -1: dir = (dir + 1) % 4
            case -2: dir = (dir + 3) % 4
            default:
                for command > 0 {
                    newX := x + dirs[dir][0]
                    newY := y + dirs[dir][1]

                    if _, exists := obs[hashCoordinates(newX, newY)]; exists {
                        break;
                    }
                    x, y = newX, newY
                    command--
                }
        }
        max = int(math.Max(float64(max), float64(x*x+y*y)))
    }

    return max
}
