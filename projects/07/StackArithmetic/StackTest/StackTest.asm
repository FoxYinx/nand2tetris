// push constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@EQUAL2
D;JEQ
@0
D=A
@SP
A=M-1
M=D
@ENDE2
0;JMP
(EQUAL2)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDE2)
// push constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 16
@16
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@EQUAL5
D;JEQ
@0
D=A
@SP
A=M-1
M=D
@ENDE5
0;JMP
(EQUAL5)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDE5)
// push constant 16
@16
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 17
@17
D=A
@SP
A=M
M=D
@SP
M=M+1
// eq  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@EQUAL8
D;JEQ
@0
D=A
@SP
A=M-1
M=D
@ENDE8
0;JMP
(EQUAL8)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDE8)
// push constant 892
@892
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@LESSER11
D;JGT
@0
D=A
@SP
A=M-1
M=D
@ENDL11
0;JMP
(LESSER11)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDL11)
// push constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 892
@892
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@LESSER14
D;JGT
@0
D=A
@SP
A=M-1
M=D
@ENDL14
0;JMP
(LESSER14)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDL14)
// push constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 891
@891
D=A
@SP
A=M
M=D
@SP
M=M+1
// lt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@LESSER17
D;JGT
@0
D=A
@SP
A=M-1
M=D
@ENDL17
0;JMP
(LESSER17)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDL17)
// push constant 32767
@32767
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@GREATER20
D;JLT
@0
D=A
@SP
A=M-1
M=D
@ENDG20
0;JMP
(GREATER20)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDG20)
// push constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 32767
@32767
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@GREATER23
D;JLT
@0
D=A
@SP
A=M-1
M=D
@ENDG23
0;JMP
(GREATER23)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDG23)
// push constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 32766
@32766
D=A
@SP
A=M
M=D
@SP
M=M+1
// gt  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D-M
D=M
@GREATER26
D;JLT
@0
D=A
@SP
A=M-1
M=D
@ENDG26
0;JMP
(GREATER26)
@0
D=A
D=!D
@SP
A=M-1
M=D
(ENDG26)
// push constant 57
@57
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 31
@31
D=A
@SP
A=M
M=D
@SP
M=M+1
// push constant 53
@53
D=A
@SP
A=M
M=D
@SP
M=M+1
// add  
@SP
M=M-1
A=M
D=M
A=A-1
M=D+M
// push constant 112
@112
D=A
@SP
A=M
M=D
@SP
M=M+1
// sub  
@SP
M=M-1
A=M-1
D=M
@SP
A=M
D=D-M
@SP
A=M-1
M=D
// neg  
@SP
A=M-1
M=-M
// and  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D&M
// push constant 82
@82
D=A
@SP
A=M
M=D
@SP
M=M+1
// or  
@SP
AM=M-1
D=M
@SP
A=M-1
M=D|M
// not  
@SP
A=M-1
M=!M