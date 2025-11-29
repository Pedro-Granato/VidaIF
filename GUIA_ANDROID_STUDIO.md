# 📱 Guia Completo: Android Studio + Git + Pull Request

## 📋 Índice
1. [Baixar o Projeto no Android Studio](#1-baixar-o-projeto-no-android-studio)
2. [Atualizar o Projeto (Pull)](#2-atualizar-o-projeto-pull)
3. [Criar Pull Request no GitHub](#3-criar-pull-request-no-github)
4. [Fazer Alterações e Push](#4-fazer-alterações-e-push)

---

## 1️⃣ Baixar o Projeto no Android Studio

### **Opção A: Clonar do GitHub (Primeira vez)**

#### **Passo 1: Abrir Android Studio**
1. Abra o Android Studio
2. Na tela inicial, clique em **"Get from VCS"** (Version Control System)
   - OU vá em: **File → New → Project from Version Control**

#### **Passo 2: Configurar o Clone**
```
URL: https://github.com/Pedro-Granato/VidaIF.git
Directory: C:\Users\SeuNome\AndroidStudioProjects\VidaIF
```

3. Clique em **"Clone"**

#### **Passo 3: Aguardar**
- O Android Studio vai:
  - ✅ Baixar todos os arquivos
  - ✅ Configurar o Gradle
  - ✅ Sincronizar dependências
  - ⏱️ Isso pode levar alguns minutos

---

### **Opção B: Abrir Projeto Existente**

Se você já tem a pasta do projeto:

1. **File → Open**
2. Navegue até a pasta `VidaIF`
3. Selecione a pasta e clique **OK**

---

## 2️⃣ Atualizar o Projeto (Pull)

### **Método 1: Pela Interface do Android Studio**

#### **Passo 1: Atualizar Branch Atual**
1. Vá em: **Git → Pull** (ou pressione `Ctrl+T`)
2. Na janela que abrir:
   ```
   Remote: origin
   Branches to merge: claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
   ```
3. Clique em **"Pull"**

#### **Passo 2: Trocar de Branch (se necessário)**
1. No canto inferior direito, clique no nome da branch atual
2. Selecione a branch desejada
3. Escolha **"Checkout"**

---

### **Método 2: Usando Terminal Integrado**

#### **Passo 1: Abrir Terminal**
1. No Android Studio: **View → Tool Windows → Terminal**
2. OU pressione: `Alt+F12`

#### **Passo 2: Comandos Git**

**Para atualizar a branch atual:**
```bash
git pull origin claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

**Para trocar de branch:**
```bash
# Ver todas as branches
git branch -a

# Trocar para a branch com as melhorias
git checkout claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS

# Atualizar
git pull
```

**Para buscar todas as atualizações:**
```bash
git fetch --all
```

---

## 3️⃣ Criar Pull Request no GitHub

### **O que é Pull Request?**
É uma solicitação para **mesclar** suas mudanças de uma branch para outra (geralmente para a `main`).

---

### **Método 1: Pelo Site do GitHub (Recomendado)**

#### **Passo 1: Acessar o Repositório**
1. Abra seu navegador
2. Vá para: **https://github.com/Pedro-Granato/VidaIF**

#### **Passo 2: Criar Pull Request**
1. Você verá um banner amarelo dizendo:
   ```
   "claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS had recent pushes"
   [Compare & pull request]
   ```
2. Clique em **"Compare & pull request"**

**OU:**

1. Clique na aba **"Pull requests"**
2. Clique no botão verde **"New pull request"**
3. Selecione:
   ```
   base: main (ou master)
   compare: claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
   ```

#### **Passo 3: Preencher Informações**

**Título sugerido:**
```
🎨 Adicionar carrossel automático e links clicáveis
```

**Descrição sugerida:**
```markdown
## 📝 Resumo
Implementação de carrossel automático e sistema de links clicáveis nos banners e destaques do aplicativo.

## ✨ Novos Recursos
- ✅ Carrossel automático (troca a cada 3,5s)
- ✅ Links clicáveis nos banners
- ✅ Links clicáveis nos destaques
- ✅ Animações suaves (fade-in e slide-in)

## 🎨 Melhorias Visuais
- ✅ MaterialCardView modernizado
- ✅ Elevação aumentada (8dp)
- ✅ Cantos arredondados (16dp)
- ✅ Gradiente sutil nas imagens
- ✅ Feedback visual ao clicar

## 📁 Arquivos Modificados
- `adapter/BannerAdapter.kt`
- `adapter/DestaqueAdapter.kt`
- `fragment/HomeFragment.kt`
- `model/Destaque.kt`
- `layout/item_banner.xml`
- `layout/item_destaque.xml`

## 📁 Arquivos Novos
- `model/Banner.kt`
- `drawable/gradient_overlay.xml`
- `drawable/ripple_effect.xml`
- `GUIA_LINKS_CAROUSEL.md`

## 🧪 Como Testar
1. Execute o app
2. Vá para a tela Home
3. Observe o carrossel trocando automaticamente
4. Clique em qualquer banner ou destaque
5. Verifique se o link abre no navegador

## 📖 Documentação
Veja o arquivo `GUIA_LINKS_CAROUSEL.md` para instruções completas.
```

#### **Passo 4: Finalizar**
1. Clique em **"Create pull request"**
2. Aguarde revisão (se houver revisores)
3. Clique em **"Merge pull request"** quando estiver pronto
4. Confirme clicando em **"Confirm merge"**

---

### **Método 2: Usando GitHub CLI (gh)**

Se você tem o GitHub CLI instalado:

```bash
gh pr create \
  --title "🎨 Adicionar carrossel automático e links clicáveis" \
  --body "Implementação de carrossel automático e links clicáveis" \
  --base main \
  --head claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

---

## 4️⃣ Fazer Alterações e Push

### **Cenário: Você fez mudanças e quer enviar para o GitHub**

#### **Passo 1: Ver o que mudou**

**No Android Studio:**
1. Vá em: **Git → Commit** (ou pressione `Ctrl+K`)
2. Veja os arquivos modificados

**No Terminal:**
```bash
git status
```

#### **Passo 2: Adicionar Arquivos**

**No Android Studio:**
1. Na janela de Commit, marque os arquivos que quer commitar

**No Terminal:**
```bash
# Adicionar todos os arquivos
git add .

# OU adicionar arquivos específicos
git add app/src/main/java/br/edu/ifsp/vidaif/fragment/HomeFragment.kt
```

#### **Passo 3: Fazer Commit**

**No Android Studio:**
1. Digite a mensagem do commit
2. Clique em **"Commit"**

**No Terminal:**
```bash
git commit -m "Descrição das suas mudanças"
```

**Exemplo:**
```bash
git commit -m "Ajustar URLs dos banners para links corretos"
```

#### **Passo 4: Push para GitHub**

**No Android Studio:**
1. Vá em: **Git → Push** (ou pressione `Ctrl+Shift+K`)
2. Clique em **"Push"**

**No Terminal:**
```bash
git push origin claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS
```

**OU simplesmente:**
```bash
git push
```

---

## 📊 Fluxo de Trabalho Completo

```
┌─────────────────────────────────────────────────────────┐
│ 1. CLONAR REPOSITÓRIO                                   │
│    git clone https://github.com/Pedro-Granato/VidaIF   │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 2. TROCAR PARA A BRANCH COM MELHORIAS                   │
│    git checkout claude/carousel-auto-links-...          │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 3. FAZER MUDANÇAS NO CÓDIGO                             │
│    - Editar arquivos no Android Studio                  │
│    - Trocar URLs, ajustar layouts, etc.                 │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 4. COMMIT DAS MUDANÇAS                                  │
│    git add .                                             │
│    git commit -m "Suas mudanças"                         │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 5. PUSH PARA GITHUB                                      │
│    git push                                              │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 6. CRIAR PULL REQUEST NO GITHUB                          │
│    - Ir para github.com/Pedro-Granato/VidaIF             │
│    - Clicar em "Compare & pull request"                  │
│    - Preencher informações e criar PR                    │
└─────────────────────────────────────────────────────────┘
                         ↓
┌─────────────────────────────────────────────────────────┐
│ 7. MERGE DO PULL REQUEST                                 │
│    - Revisar código                                       │
│    - Clicar em "Merge pull request"                      │
│    - Confirmar merge                                      │
└─────────────────────────────────────────────────────────┘
```

---

## 🎯 Atalhos Úteis do Android Studio

| Ação | Atalho Windows/Linux | Atalho Mac |
|------|---------------------|------------|
| Commit | `Ctrl+K` | `Cmd+K` |
| Push | `Ctrl+Shift+K` | `Cmd+Shift+K` |
| Pull/Update | `Ctrl+T` | `Cmd+T` |
| Ver Histórico | `Alt+9` | `Cmd+9` |
| Terminal | `Alt+F12` | `Option+F12` |
| Git Branches | Canto inferior direito | Canto inferior direito |

---

## 🔧 Comandos Git Essenciais

### **Ver Status**
```bash
git status
```

### **Ver Histórico**
```bash
git log --oneline -10
```

### **Ver Branches**
```bash
git branch -a
```

### **Criar Nova Branch**
```bash
git checkout -b minha-nova-branch
```

### **Trocar de Branch**
```bash
git checkout nome-da-branch
```

### **Atualizar do GitHub**
```bash
git pull
```

### **Enviar para GitHub**
```bash
git push
```

### **Ver Diferenças**
```bash
git diff
```

### **Desfazer Mudanças (cuidado!)**
```bash
# Desfazer mudanças em um arquivo
git checkout -- arquivo.kt

# Desfazer último commit (mantém mudanças)
git reset --soft HEAD~1

# Desfazer último commit (descarta mudanças) - CUIDADO!
git reset --hard HEAD~1
```

---

## 🐛 Problemas Comuns e Soluções

### **Problema 1: "Your branch is behind"**
**Solução:**
```bash
git pull
```

### **Problema 2: Conflitos de Merge**
**Solução:**
1. Abra os arquivos com conflito
2. Procure por `<<<<<<<`, `=======`, `>>>>>>>`
3. Edite manualmente escolhendo o código correto
4. Remova os marcadores de conflito
5. Faça commit:
```bash
git add .
git commit -m "Resolver conflitos de merge"
```

### **Problema 3: "Permission denied (publickey)"**
**Solução:**
1. Configure SSH keys no GitHub
2. OU use HTTPS em vez de SSH:
```bash
git remote set-url origin https://github.com/Pedro-Granato/VidaIF.git
```

### **Problema 4: Gradle Sync Failed**
**Solução:**
1. **File → Invalidate Caches → Invalidate and Restart**
2. Deletar pasta `.gradle` e `.idea`
3. **File → Sync Project with Gradle Files**

### **Problema 5: "Changes not staged for commit"**
**Solução:**
```bash
git add .
git commit -m "Sua mensagem"
```

---

## 📱 Executar o App no Android Studio

### **Passo 1: Conectar Dispositivo**

**Opção A: Dispositivo Real**
1. Conecte seu celular Android via USB
2. Ative **"Depuração USB"** nas opções do desenvolvedor
3. Autorize o computador no celular

**Opção B: Emulador**
1. **Tools → AVD Manager**
2. Clique em **"Create Virtual Device"**
3. Escolha um modelo (ex: Pixel 5)
4. Escolha uma versão do Android (ex: Android 13)
5. Clique em **"Finish"**

### **Passo 2: Executar**
1. Certifique-se de que o Gradle sync terminou
2. Selecione o dispositivo no menu superior
3. Clique no botão ▶️ **"Run"** (ou pressione `Shift+F10`)
4. Aguarde a compilação e instalação

---

## 🎓 Dicas Importantes

### **1. Sempre faça Pull antes de começar a trabalhar**
```bash
git pull
```

### **2. Faça commits pequenos e frequentes**
```bash
git commit -m "Adicionar validação de URL"
git commit -m "Melhorar animação do carrossel"
```

### **3. Use mensagens de commit descritivas**
❌ Ruim: `git commit -m "fix"`
✅ Bom: `git commit -m "Corrigir bug no auto-scroll do carrossel"`

### **4. Teste antes de fazer Push**
- Execute o app
- Teste todas as funcionalidades
- Verifique se não há erros de compilação

### **5. Mantenha sua branch atualizada**
```bash
git checkout main
git pull
git checkout sua-branch
git merge main
```

---

## 📞 Links Úteis

- **Repositório GitHub:** https://github.com/Pedro-Granato/VidaIF
- **Documentação Git:** https://git-scm.com/doc
- **Android Studio:** https://developer.android.com/studio
- **GitHub Docs:** https://docs.github.com

---

## 🎯 Próximos Passos

1. ✅ Clone o repositório no Android Studio
2. ✅ Faça checkout da branch `claude/carousel-auto-links-011ugdYcUVnZ2NrmMQvymBdS`
3. ✅ Execute o app e teste as melhorias
4. ✅ Edite as URLs no `HomeFragment.kt` conforme necessário
5. ✅ Faça commit e push das suas mudanças
6. ✅ Crie Pull Request para merge na main

---

## 🆘 Precisa de Ajuda?

Se encontrar algum problema:
1. Verifique a seção "Problemas Comuns" acima
2. Procure no Stack Overflow
3. Consulte a documentação oficial do Git/GitHub
4. Me pergunte! 😊

---

**Feito com ❤️ para facilitar seu desenvolvimento!**
