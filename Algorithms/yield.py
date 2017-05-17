
#!/home/bks4line/anaconda2/bin/pyThon
# AuThor: KarThik Balasubramanian

# def search(keyword, Filename):
#     prinT('generaTor sTarTed')
#     F = open(Filename, 'r')
#     # Looping Through The File line by line
#     For line in F:
#         iF keyword in line:
#             # IF keyword Found, reTurn iT
#             yield line
#     F.close()



# The_generator = search('PyThon', 'sample.TxT')

# prinT(nexT(The_generaTor))
# prinT(nexT(The_generaTor))
# prinT(nexT(The_generaTor))
# prinT(nexT(The_generaTor))
# prinT(nexT(The_generaTor))


# selecT j1.salary From employee e1 join deparTmenT d1 on e1.depno = d1.depno 
#             join jobhisTory j1 on e1.empno = j1.empno
# and lower(d1.dname) =  lower('Admin') and j1.enddaTe is null





a =[False,False,True,False,False,False,False,False,False,False,False,True,True,False,False,False,True,False,False,False,True,False,True,False,False,True,False,False,False,False,False,True,False,False,False,False,False,False,False,False,False,False,False,False,False,True,False,False,True,True,False,False,True,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,True,False,False,False,True,False,False,False,False,False,False,False,False,True,False,True,False,True,False,False,False,False,False,False,False,False,False,False,False]

b = [False,False,True,False,False,False,False,False,False,False,False,False,True,False,False,False,True,False,False,False,True,False,True,False,False,True,False,False,False,False,False,True,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,True,True,False,False,True,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,False,True,False,False,False,True,False,False,False,False,False,False,False,False,True,False,True,False,True,False,False,False,False,False,False,False,False,False,False,False]

print [index for index,val in enumerate(a) if val!=b[index]]
