# 📸 Git no Android Studio - Passo a Passo Visual

## 🎯 Opção Mais Simples: Usar o Terminal

**Você NÃO precisa do menu Git!** Use apenas o Terminal integrado:

---

## ⚡ MÉTODO RÁPIDO (Recomendado)

### **1. Abrir Terminal no Android Studio**

```
Pressione: Alt + F12
```

OU

```
Menu: View → Tool Windows → Terminal
```

Vai aparecer um terminal na parte inferior da tela:

```
┌──────────────────────────────────────────────┐
│ Terminal                                  [X]│
├──────────────────────────────────────────────┤
│ C:\...\VidaIF>                              │
│                                              │
└──────────────────────────────────────────────┘
```

---

### **2. Digitar Comandos Git Diretamente**

```bash
# Ver status do projeto
git status

# Trocar para branch com melhorias
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS

# Atualizar projeto
git pull

# Ver branches disponíveis
git branch -a

# Ver últimos commits
git log --oneline -5
```

---

### **3. Fazer Mudanças e Enviar para GitHub**

```bash
# Ver o que mudou
git status

# Adicionar todos os arquivos
git add .

# Fazer commit
git commit -m "Atualizar URLs dos banners"

# Enviar para GitHub
git push
```

**PRONTO! Você não precisa de menus! ✅**

---

## 🔧 Se Preferir Usar Menu Git (Configuração)

### **Passo 1: Verificar se Git está Instalado**

#### **Windows:**

1. Pressionar `Win + R`
2. Digitar `cmd` e pressionar Enter
3. No Prompt, digitar:
```cmd
git --version
```

**Resultado Esperado:**
```
git version 2.43.0
```

**Se aparecer erro:** Git não está instalado ❌

---

#### **Instalar Git (se necessário):**

1. Ir para: **https://git-scm.com/download/win**
2. Baixar instalador
3. Executar e seguir passos (deixar tudo padrão)
4. **REINICIAR Android Studio**

---

### **Passo 2: Configurar Git no Android Studio**

1. **Abrir Settings:**
   ```
   File → Settings (Ctrl + Alt + S)
   ```

2. **Navegar até:**
   ```
   Version Control → Git
   ```

3. **Configurar caminho do Git:**

   Clicar em **"..."** ao lado de "Path to Git executable"

   **Selecionar:**
   ```
   C:\Program Files\Git\bin\git.exe
   ```

   OU

   ```
   C:\Program Files (x86)\Git\bin\git.exe
   ```

4. **Clicar em "Test"**

   Deve aparecer:
   ```
   Git version 2.43.0
   ```

5. **Clicar OK e Apply**

---

### **Passo 3: Habilitar VCS no Projeto**

1. **Menu Superior:**
   ```
   VCS → Enable Version Control Integration
   ```

2. **Selecionar "Git"** no dropdown

3. **Clicar OK**

---

### **Passo 4: Verificar Menu Git**

Agora você deve ver:

```
┌────────────────────────────────────────────────┐
│ File Edit View Navigate Code Refactor Build   │
│                                         ↓      │
│ Menu "Git" deve aparecer aqui                 │
└────────────────────────────────────────────────┘
```

---

## 📱 Onde Está o Menu Git?

### **Localização 1: Menu Principal (Topo)**

```
File  Edit  View  Navigate  Code  Refactor  Build  Run  Git
                                                        ↑↑↑
                                                   Aqui!
```

Clicar em **"Git"** mostra:
- ✅ Commit...
- ⬆️ Push...
- ⬇️ Pull...
- 🌿 Branches...
- 📜 Show History
- 🔄 Fetch

---

### **Localização 2: Barra Lateral (Alt+9)**

```
Lado Esquerdo da Tela:

┌──────────┐
│ Project  │ ← Alt+1
│ Commit   │ ← Alt+0
│ Git      │ ← Alt+9  👈 Clique aqui!
│ ...      │
└──────────┘
```

---

### **Localização 3: Canto Inferior Direito**

```
Parte Inferior Direita:

┌─────────────────────────────────────┐
│ 🌿 claude/carousel-auto-links-...  │ 👈 Nome da branch
│                                     │    (Clique para trocar)
└─────────────────────────────────────┘
```

Clicar no nome da branch mostra:
- Lista de todas as branches
- Opção de trocar (Checkout)
- Criar nova branch
- etc.

---

### **Localização 4: Botão Direito no Arquivo**

1. Clicar com **botão direito** em qualquer arquivo
2. Procurar opção **"Git"** no menu
3. Vai mostrar:
   - Add
   - Commit File...
   - Compare with Branch
   - Show History
   - Revert...

---

## 🎨 Layout Completo do Android Studio com Git

```
┌───────────────────────────────────────────────────────────┐
│ File Edit View Navigate Code Refactor Build Run Git  ... │ ← Menu Git
├───────────────────────────────────────────────────────────┤
│ ┌──────┐ ┌─────────────────────────────────────────┐    │
│ │Proje │ │                                          │    │
│ │ct    │ │         CÓDIGO AQUI                      │    │
│ │      │ │                                          │    │
│ │ Home │ │                                          │    │
│ │Fragm │ │                                          │    │
│ │ent.kt│ │                                          │    │
│ └──────┘ └─────────────────────────────────────────┘    │
│ ┌──────────────────────────────────────────────────────┐ │
│ │ Terminal                                         [X] │ │
│ ├──────────────────────────────────────────────────────┤ │
│ │ C:\VidaIF> git status                               │ │ ← Terminal Git
│ │ On branch claude/carousel-auto-links-...            │ │
│ └──────────────────────────────────────────────────────┘ │
│                          🌿 claude/carousel-auto-li... 👈 │ ← Nome Branch
└───────────────────────────────────────────────────────────┘
      ↑
   Git Alt+9
```

---

## ✅ Checklist: Git Está Funcionando?

Marque conforme verifica:

- [ ] Terminal abre com `Alt + F12`
- [ ] Comando `git status` funciona no terminal
- [ ] Comando `git branch` mostra branches
- [ ] Menu "Git" aparece no menu superior
- [ ] Nome da branch aparece no canto inferior direito
- [ ] Janela Git abre com `Alt + 9`

**Se pelo menos os 3 primeiros ✅ funcionam, você está OK!**

---

## 🚀 Comandos Mais Usados (Terminal)

### **Ver Informações:**
```bash
git status              # Ver status atual
git branch              # Ver branches locais
git branch -a           # Ver todas as branches
git log --oneline -10   # Ver últimos 10 commits
```

### **Trocar Branch:**
```bash
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

### **Atualizar:**
```bash
git pull                # Baixar atualizações
git fetch               # Buscar atualizações (sem aplicar)
```

### **Fazer Mudanças:**
```bash
git add .                              # Adicionar todos arquivos
git commit -m "Sua mensagem aqui"      # Fazer commit
git push                               # Enviar para GitHub
```

### **Desfazer (Cuidado!):**
```bash
git checkout -- arquivo.kt             # Desfazer mudança em arquivo
git reset HEAD arquivo.kt              # Remover arquivo do staging
```

---

## 🎯 Fluxo de Trabalho Completo

### **1. Abrir Projeto**
```
File → Open → Selecionar pasta VidaIF
```

### **2. Abrir Terminal**
```
Alt + F12
```

### **3. Verificar Branch**
```bash
git branch
```

### **4. Trocar para Branch com Melhorias**
```bash
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
git pull
```

### **5. Editar Código**
- Abrir: `HomeFragment.kt`
- Editar URLs (linha 57 e 117)
- Salvar: `Ctrl + S`

### **6. Fazer Commit e Push**
```bash
git add .
git commit -m "Atualizar URLs dos banners e destaques"
git push
```

**PRONTO!** ✅

---

## 🐛 Se Nada Funcionar...

### **Solução Alternativa: GitHub Desktop**

1. **Baixar:** https://desktop.github.com/
2. **Instalar** GitHub Desktop
3. **File → Clone Repository**
4. **Selecionar:** `Pedro-Granato/VidaIF`
5. **Escolher local:** `C:\...\VidaIF`

Agora você tem interface gráfica para Git! 🎉

**No GitHub Desktop você pode:**
- ✅ Ver mudanças
- ✅ Fazer commits
- ✅ Fazer push/pull
- ✅ Trocar branches
- ✅ Criar pull requests

E continua editando código no Android Studio normalmente!

---

## 💡 Dica de Ouro

**O Terminal é MAIS RÁPIDO que usar menus!**

Compare:

**Com Menu:**
1. Git → Commit
2. Selecionar arquivos
3. Escrever mensagem
4. Clicar Commit
5. Git → Push
6. Clicar OK

**Com Terminal:**
```bash
git add . && git commit -m "Mensagem" && git push
```

**1 linha vs 6 cliques!** 🚀

---

## 📞 Precisa de Ajuda?

**Me diga:**
1. Qual mensagem de erro aparece?
2. O comando `git --version` funciona no terminal?
3. Você consegue ver o Terminal no Android Studio?

Vou te ajudar a resolver! 😊
