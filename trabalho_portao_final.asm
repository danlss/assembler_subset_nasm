section .data
portaoFechado	db 10,"              >>>>>>>>PORTAO FECHADO!<<<<<<<<", 10,"'---------------------            -------------------------'", 10, "'    /    /    /    /|		  /   /    /    /    /   / '", 10,  "'-------------------/|           |----------------------   '", 10, "'   |    |     |    |--------------------|    |    |    |  '", 10,  "'-------------------|                    |--------------   '", 10,  "'     |     |     | |                    |     |    |      '", 10, "'-----------------x||                    |--------------   '", 10, "'   |    |     |    |                    |    |    |    |  '", 10,  "'-------------------|                    |--------------   '", 10, "'             fcf  /|0-----()-----()-----| fca             '", 10,  "'                 /            /                           '", 10,  "'                /            /                            '", 10, "'               /            /                             '", 10, "'              /            /                              '", 10, "'             /            /                               '", 10, "'            /            /                                '", 10, "'    / \                                                   '", 10, "'   /   \                                                  '", 10, "'     |                                                    '", 10, "'     |                                                    '", 10, "'   |---|                                                  '", 10, "'   | 0 | ba/fca                                           '", 10, "'   | 1 | bf/fcf                                           '", 10, "'   |---|                                                  '", 0
lportaoFechado	equ $ - portaoFechado
portaoAbrindo	db 10,"              >>>>>>>>PORTAO ABRINDO!<<<<<<<<", 10,"'----------------------            ---------------------'", 10, "'     /     /    /   /|           /     /     /    /   /'", 10, "'--------------------/|            -------------------  '", 10, "'    |     |     |  | |     -------------------    |  | '", 10, "'--------------------/|     |                 |-------  '", 10, "'      |      |     | |     |                 | |   |   '", 10, "'--------------------/|  x| |                 |-------  '", 10, "'    |     |     |  | |     |                 |   |   | '", 10, "'--------------------/      |                 |-------  '", 10, "'               fcf /       |0----()----()----|  fca    '", 10, "'                  /            /                       '", 10, "'                 /    --->    /                        '", 10, "'                /            /                         '", 10, "'               /            /                          '", 10, "'              /            /                           '", 10, "'             /            /                            '", 10, "'   / \                                                 '", 10, "'  /   \                                                '", 10, "'    |                                                  '", 10, "'    |                                                  '", 10, "'  |---|                                                '", 10, "'  | 0 | ba/fca                                         '", 10, "'  | 1 | bf/fcf                                         '", 10, "'  |---|                                                '", 0
lportaoAbrindo	equ $ - portaoAbrindo
portaoAberto	db 10,"              >>>>>>>>PORTAO ABERTO!<<<<<<<<", 10,"'----------------------            ---------------------'", 10, "'     /     /    /   /|           /     /     /    /   /'", 10, "'--------------------/|            -------------------  '", 10, "'    |     |     |  | |           -------------------  |'", 10, "'--------------------/|           |                 |---'", 10, "'      |      |     | |           |                 |   '", 10, "'--------------------/|         x||                 |---'", 10, "'    |     |     |  | |           |                 | | '", 10, "'--------------------/            |                 |---'", 10, "'               fcf /             |0----()----()----|fca'", 10, "'                  /            /                       '", 10, "'                 /            /                        '", 10, "'                /            /                         '", 10, "'               /            /                          '", 10, "'              /            /                           '", 10, "'             /            /                            '", 10, "'   / \                                                 '", 10, "'  /   \                                                '", 10, "'    |                                                  '", 10, "'    |                                                  '", 10, "'  |---|                                                '", 10, "'  | 0 | ba/fca                                         '", 10, "'  | 1 | bf/fcf                                         '", 10, "'  |---|                                                '", 0
lportaoAberto	equ $ - portaoAberto	
portaoFechando	db 10,"              >>>>>>>>PORTAO FECHANDO!<<<<<<<<", 10,"'----------------------            ---------------------'", 10, "'     /     /    /   /|           /     /     /    /   /'", 10, "'--------------------/|            -------------------  '", 10, "'    |     |     |  | |     -------------------    |  | '", 10, "'--------------------/|     |                 |-------  '", 10, "'      |      |     | |     |                 | |   |   '", 10, "'--------------------/|  x| |                 |-------  '", 10, "'    |     |     |  | |     |                 |   |   | '", 10, "'--------------------/      |                 |-------  '", 10, "'               fcf /       |0----()----()----|  fca    '", 10, "'                  /            /                       '", 10, "'                 /    <---    /                        '", 10, "'                /            /                         '", 10, "'               /            /                          '", 10, "'              /            /                           '", 10, "'             /            /                            '", 10, "'   / \                                                 '", 10, "'  /   \                                                '", 10, "'    |                                                  '", 10, "'    |                                                  '", 10, "'  |---|                                                '", 10, "'  | 0 | ba/fca                                         '", 10, "'  | 1 | bf/fcf                                         '", 10, "'  |---|                                                '", 0
lportaoFechando	equ $ - portaoFechando	
botaoA	db 10, "(0) Abrir", 0
lbotaoA	equ $ - botaoA
botaoFCA db 10, "(0) Final de Curso Abrir",0
lbotaoFCA equ $ - botaoFCA	
botaoF 	db 10, "(1) Fechar", 0
lbotaoF equ $ - botaoF
botaoFCF db 10, "(1) Final de Curso Fechar",0
lbotaoFCF equ $ - botaoFCF
sensorX db 10, "(2) X - Sensor", 0
lsensorX equ $ - sensorX
msgOpc 	db 10, "Operação? ", 0
lmsgOpc equ $ - msgOpc
msgErr 	db 10, "Opcao invalida!", 10, "Saindo...", 10, 0
lmsgErr equ $ - msgErr
section .bss
opc	resb 2
section .text
global _start
;programa principal.
_start:
;inicia no estado fechado.
jmp fechado
;Estados do portão.
abrindo:
mov ecx, portaoAbrindo
mov edx, lportaoAbrindo
call mst_saida
mov ecx, botaoFCA	
mov edx, lbotaoFCA
call mst_saida
mov ecx, botaoF	
mov edx, lbotaoF
call mst_saida
mov ecx, sensorX
mov edx, lsensorX
call mst_saida
mov ecx, msgOpc
mov edx, lmsgOpc
call mst_saida
mov ecx, opc
mov edx, 2
mov eax, 3
mov ebx, 0
int 80h
mov ah, [opc]
sub ah, '0'
cmp ah, 0
je aberto
cmp ah, 1
je fechando
cmp ah, 2
je abrindo
jmp exit
fechando:
mov ecx, portaoFechando
mov edx, lportaoFechando
call mst_saida
mov ecx, botaoA	
mov edx, lbotaoA
call mst_saida
mov ecx, botaoFCF	
mov edx, lbotaoFCF
call mst_saida
mov ecx, sensorX
mov edx, lsensorX
call mst_saida
mov ecx, msgOpc
mov edx, lmsgOpc
call mst_saida
mov ecx, opc
mov edx, 2
mov eax, 3
mov ebx, 0
int 80h
mov ah, [opc]
sub ah, '0'
cmp ah, 0
je abrindo
cmp ah, 1
je fechado
cmp ah, 2
je abrindo	
jmp exit
aberto:
mov ecx, portaoAberto
mov edx, lportaoAberto
call mst_saida
mov ecx, botaoA
mov edx, lbotaoA
call mst_saida
mov ecx, botaoF	
mov edx, lbotaoF
call mst_saida
mov ecx, sensorX	
mov edx, lsensorX
call mst_saida
mov ecx, msgOpc
mov edx, lmsgOpc
call mst_saida
mov ecx, opc
mov edx, 2
mov eax, 3
mov ebx, 0
int 80h
mov ah, [opc]
sub ah, '0'
cmp ah, 0
je aberto
cmp ah, 1
je fechando
cmp ah, 2
je aberto
jmp exit	
fechado:
mov ecx, portaoFechado
mov edx, lportaoFechado
call mst_saida
mov ecx, botaoA
mov edx, lbotaoA
call mst_saida
mov ecx, botaoF	
mov edx, lbotaoF
call mst_saida
mov ecx, sensorX	
mov edx, lsensorX
call mst_saida
mov ecx, msgOpc
mov edx, lmsgOpc
call mst_saida
mov ecx, opc
mov edx, 2
mov eax, 3
mov ebx, 0
int 80h
mov ah, [opc]
sub ah, '0'
cmp ah, 0
je abrindo
cmp ah, 1
je fechado
cmp ah, 2
je fechado
jmp exit
mst_saida:
mov eax, 4
mov ebx, 1
int 80h 
ret
exit:	
mov ecx, msgErr
mov edx, lmsgErr
call mst_saida
mov eax, 1
mov ebx, 0
int 80h