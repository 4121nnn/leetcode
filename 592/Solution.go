func fractionAddition(s string) string {
    num, den := 0, 1
    for i := 0; i < len(s);{
        sign := 1
        if s[i] == '-' {
            sign *= -1
            i++
        }else if s[i] == '+'{
            i++
        }

        j := i
        for j < len(s) && unicode.IsDigit(rune(s[j])){
            j++
        }
        curNum, _ := strconv.Atoi(s[i:j])
        curNum *= sign
        i = j + 1

        j = i
        for j < len(s) && unicode.IsDigit(rune(s[j])){
            j++
        }
        curDen, _ := strconv.Atoi(s[i:j])
        i = j

        num = num*curDen + curNum*den
        den *= curDen

        gcdVal := gcd(abs(num), den)
        num /= gcdVal
        den /= gcdVal
    }
    return fmt.Sprintf("%d/%d", num, den)
}

func gcd(a, b int) int{
    if b == 0 { return a }
    return gcd(b, a%b)
}
func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
