# 🔧 Resolver: Git Não Aparece no Android Studio

## 🎯 Soluções Rápidas

---

## ✅ Solução 1: Instalar Git no Windows

### **Passo 1: Verificar se Git está instalado**

1. Abrir **Prompt de Comando** (CMD)
   - Pressione `Win + R`
   - Digite `cmd`
   - Pressione Enter

2. Digite:
```cmd
git --version
```

**Se aparecer algo como:** `git version 2.43.0` → Git está instalado ✅

**Se aparecer:** `'git' não é reconhecido...` → Git NÃO está instalado ❌

---

### **Passo 2: Baixar e Instalar Git (se necessário)**

1. Ir para: **https://git-scm.com/download/win**
2. Baixar o instalador para Windows
3. Executar o instalador
4. **IMPORTANTE:** Durante a instalação, selecione:
   - ✅ **"Git from the command line and also from 3rd-party software"**
   - ✅ Deixe todas as outras opções padrão
5. Clicar em **"Next"** até finalizar
6. **REINICIAR o Android Studio**

---

## ✅ Solução 2: Configurar Git no Android Studio

### **Passo 1: Acessar Configurações**

1. No Android Studio, ir em:
   - **File → Settings** (Windows/Linux)
   - OU **Android Studio → Preferences** (Mac)
   - OU pressionar: `Ctrl + Alt + S`

### **Passo 2: Configurar Caminho do Git**

1. No menu lateral, procurar:
   ```
   Version Control → Git
   ```

2. Em **"Path to Git executable"**, clicar em **"..."** (três pontos)

3. Navegar até onde o Git está instalado:

   **Windows (locais comuns):**
   ```
   C:\Program Files\Git\bin\git.exe
   C:\Program Files (x86)\Git\bin\git.exe
   C:\Users\SeuNome\AppData\Local\Programs\Git\bin\git.exe
   ```

   **Mac:**
   ```
   /usr/bin/git
   /usr/local/bin/git
   ```

   **Linux:**
   ```
   /usr/bin/git
   ```

4. Clicar em **"Test"** para verificar
   - Deve aparecer: **"Git version X.XX.X"** ✅

5. Clicar em **"OK"** e depois **"Apply"**

---

## ✅ Solução 3: Habilitar Controle de Versão no Projeto

### **Método A: Pela Interface**

1. No Android Studio, ir em:
   ```
   VCS → Enable Version Control Integration
   ```

2. Selecionar **"Git"** no dropdown

3. Clicar em **"OK"**

---

### **Método B: Pelo Terminal**

1. Abrir Terminal no Android Studio (`Alt + F12`)

2. Verificar se a pasta é um repositório Git:
```bash
git status
```

**Se não for repositório Git:**
```bash
git init
git remote add origin https://github.com/Pedro-Granato/VidaIF.git
git fetch
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

---

## ✅ Solução 4: Reabrir Projeto como VCS

### **Passo 1: Fechar Projeto**
```
File → Close Project
```

### **Passo 2: Reabrir do Git**
1. Na tela inicial, clicar em **"Get from VCS"**

2. Preencher:
   ```
   URL: https://github.com/Pedro-Granato/VidaIF.git
   Directory: C:\Users\SeuNome\AndroidStudioProjects\VidaIF
   ```

3. Clicar em **"Clone"**

Agora o menu Git deve aparecer! ✅

---

## ✅ Solução 5: Mostrar Menu Git (se estava escondido)

### **Opção A: Ativar no Menu**
```
View → Tool Windows → Git
```

### **Opção B: Atalho**
Pressionar: `Alt + 9`

### **Opção C: Barra Inferior**
Clicar em **"Git"** na barra inferior da janela do Android Studio

---

## 🎯 Onde Encontrar as Opções do Git

Após configurar, você verá:

### **1. Menu Principal**
```
Menu Superior → Git →
  ├── Commit (Ctrl+K)
  ├── Push (Ctrl+Shift+K)
  ├── Pull (Ctrl+T)
  ├── Fetch
  ├── Branches
  └── Show History
```

### **2. Barra de Ferramentas Superior**
Ícones de Git (se habilitados):
- ✅ Commit
- ⬆️ Push
- ⬇️ Pull
- 🌿 Branches

### **3. Janela Git (Alt+9)**
- Painel lateral à esquerda
- Mostra branches, commits, etc.

### **4. Canto Inferior Direito**
Nome da branch atual (ex: `claude/carousel-auto-links-...`)

### **5. Botão Direito no Projeto**
Clicar com botão direito em qualquer arquivo:
```
Git →
  ├── Add
  ├── Commit File
  ├── Compare with Branch
  └── Show History
```

---

## 🖼️ Interface Visual Esperada

```
┌─────────────────────────────────────────────────────────┐
│ File  Edit  View  Navigate  Code  Refactor  Build  Run │
│                          ↑                               │
│                    Menu "Git" deve aparecer aqui        │
└─────────────────────────────────────────────────────────┘

Canto Inferior Direito:
┌────────────────────────────────┐
│ 🌿 claude/carousel-auto-lin... │  ← Nome da branch
└────────────────────────────────┘

Barra Lateral Esquerda:
┌────────────┐
│ 1: Project │
│ 9: Git     │  ← Alt+9 para abrir
│ ...        │
└────────────┘
```

---

## 🔍 Verificar Configuração do Git

### **Terminal do Android Studio:**

```bash
# Ver versão do Git
git --version

# Ver configuração do usuário
git config --global user.name
git config --global user.email

# Ver repositório remoto
git remote -v

# Ver status
git status

# Ver branches
git branch -a
```

---

## ⚙️ Configurar Usuário Git (se necessário)

Se o Git estiver instalado mas não configurado:

### **No Terminal do Android Studio:**

```bash
# Configurar nome
git config --global user.name "Seu Nome"

# Configurar email
git config --global user.email "seuemail@example.com"

# Verificar configuração
git config --list
```

---

## 🎨 Alternativa: Usar APENAS o Terminal

Se o menu Git não aparecer, você pode usar apenas comandos:

### **Abrir Terminal:** `Alt + F12`

### **Comandos Essenciais:**

```bash
# Ver status
git status

# Ver branch atual
git branch

# Trocar branch
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS

# Atualizar
git pull

# Adicionar arquivos
git add .

# Commit
git commit -m "Sua mensagem"

# Push
git push

# Ver histórico
git log --oneline -10
```

---

## 🐛 Problemas Específicos

### **Problema: "Git not found"**
**Solução:**
1. Instalar Git: https://git-scm.com/download/win
2. Reiniciar Android Studio
3. Configurar caminho em Settings → Version Control → Git

---

### **Problema: Menu Git aparece mas está vazio**
**Solução:**
1. File → Invalidate Caches → Invalidate and Restart
2. Reabrir projeto

---

### **Problema: "Not a Git repository"**
**Solução:**
```bash
# No terminal:
git init
git remote add origin https://github.com/Pedro-Granato/VidaIF.git
git fetch
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

---

### **Problema: Não consigo fazer Push/Pull**
**Solução:**
1. Verificar conexão com internet
2. Verificar credenciais do GitHub
3. Pode precisar de token de acesso pessoal

**Gerar Token no GitHub:**
1. GitHub → Settings → Developer Settings
2. Personal Access Tokens → Tokens (classic)
3. Generate new token
4. Selecionar: `repo` (todas as opções)
5. Copiar token
6. Usar como senha no Android Studio

---

## 📱 Usar Git Sem Interface Gráfica

### **GitHub Desktop (Alternativa Fácil)**

Se preferir uma interface gráfica separada:

1. Baixar: **https://desktop.github.com/**
2. Instalar GitHub Desktop
3. File → Clone Repository
4. Selecionar `Pedro-Granato/VidaIF`
5. Usar GitHub Desktop para commits/push/pull
6. Continuar editando no Android Studio

---

## ✅ Checklist de Verificação

- [ ] Git está instalado (`git --version`)
- [ ] Android Studio reconhece Git (Settings → Version Control → Git)
- [ ] Pasta do projeto é repositório Git (`git status`)
- [ ] Menu Git aparece no Android Studio
- [ ] Consigo ver branches (canto inferior direito)
- [ ] Consigo fazer Pull/Push pelo terminal
- [ ] Usuario Git configurado (`git config --global user.name`)

---

## 🆘 Ainda Não Funciona?

### **Solução Definitiva: Usar Terminal**

Mesmo sem o menu Git no Android Studio, você consegue fazer TUDO pelo terminal:

**Terminal do Android Studio (Alt+F12):**

```bash
# 1. Ver status
git status

# 2. Atualizar projeto
git pull

# 3. Fazer mudanças nos arquivos...

# 4. Adicionar mudanças
git add .

# 5. Commit
git commit -m "Atualizar URLs dos links"

# 6. Enviar para GitHub
git push
```

**É a mesma coisa que usar o menu Git!** 😊

---

## 📞 Links Úteis

- **Download Git:** https://git-scm.com/download/win
- **GitHub Desktop:** https://desktop.github.com/
- **Documentação Git:** https://git-scm.com/doc
- **Seu Repositório:** https://github.com/Pedro-Granato/VidaIF

---

## 💡 Dica Final

**Você NÃO precisa do menu Git do Android Studio!**

Basta usar o **Terminal integrado** (`Alt + F12`) e digitar os comandos Git.

É até mais rápido! 🚀

---

**Me diga qual erro específico está aparecendo para eu te ajudar melhor!** 😊
