func asteroidsDestroyed(mass int, asteroids []int) bool {
    max := 0
    for _, val := range asteroids {
        if max < val {
            max = val
        }
    }
    a := make([]int, max + 1)
    for _, val := range asteroids {
        a[val]++
    }
    for i := range max + 1 {
        if i > mass {
            return false
        }
        if mass > 100000 {
            return true
        }
        mass += a[i] * i
    }
    return true
}
