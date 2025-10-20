function1:
       cmpl    %ecx, %edx
       jg      .L4
       subq    $8, %rsp
       movq    %rdi, %r8
       movl    %esi, %edi
       leal    (%rdx,%rcx), %eax
       movl    %eax, %esi
       shrl    $31, %esi
       addl    %eax, %esi
       sarl    %esi
       movl    %esi, %eax
       movslq  %esi, %r9
       movl    (%r8,%r9,4), %r9d
       cmpl    %edi, %r9d
       je      .L1
       jge     .L3
       leal    1(%rsi), %edx
       movl    %edi, %esi
       movq    %r8, %rdi
       call    function1
.L1:
       addq    $8, %rsp
       ret
.L3:
       leal    -1(%rsi), %ecx
       movl    %edi, %esi
       movq    %r8, %rdi
       call    function1
       jmp     .L1
.L4:
       movl    $-1, %eax
       ret
.LC0:
       .string "Index of %d in the array is %d\n"



main:
       subq    $56, %rsp
       movl    $11, (%rsp)
       movl    $20, 4(%rsp)
       movl    $35, 8(%rsp)
       movl    $47, 12(%rsp)
       movl    $56, 16(%rsp)
       movl    $68, 20(%rsp)
       movl    $79, 24(%rsp)
       movl    $81, 28(%rsp)
       movl    $90, 32(%rsp)
       movl    $8, %ecx
       movl    $0, %edx
       movl    $56, %esi
       movq    %rsp, %rdi
       call    function1
       movl    %eax, %edx
       movl    $56, %esi
       movl    $.LC0, %edi
       movl    $0, %eax
       call    printf
       movl    $0, %eax
       addq    $56, %rsp
       ret

